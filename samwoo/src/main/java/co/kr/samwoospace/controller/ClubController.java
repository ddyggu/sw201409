package co.kr.samwoospace.controller;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.samwoospace.bean.ClubRecord;
import co.kr.samwoospace.bean.EncodedFile;
import co.kr.samwoospace.bean.ResponStatus;
import co.kr.samwoospace.dao.memberDAO;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.service.FileService;
import co.kr.samwoospace.util.Paging;

@Controller
@SessionAttributes({"member","clubRecord","club_fileList"})
public class ClubController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="memberDAO")
	private memberDAO memberDao;
	
	@Resource(name="fileService")
	private FileService fileService;
	
	private static final String table = "club";
	private static final String table_ko = "동호회";
	
	private static final String insert_s_msg = "동호회 등록이 완료되었습니다.";
	private static final String update_s_msg = "동호회 수정이 완료되었습니다.";
	
	@RequestMapping("/admin/club")
	public String clubList(@RequestParam(required=false) Integer pageNum, Model model) {
		if (pageNum == null) { pageNum = 1; }
	
		Paging paging = boardService.selectPagingInfo(table, "club", pageNum);
		List<ClubRecord> clubList = boardService.ListClubRecord(paging);
		
		model.addAttribute("clubList", clubList);
		model.addAttribute("paging", paging.makePageGroup());
		
		return "/admin/club"; 
	}
	
	@RequestMapping("/admin/clubView")
	public String clubView(@RequestParam Integer pageNum, @RequestParam int num, Model model) {
		
		if(pageNum == null) { pageNum = 1; }
		
		ClubRecord record = boardService.selectOneClubRecord(num);
		List<EncodedFile> fileList = fileService.selectFileInfo(table, num);
		boardService.updateViewCount(table, num);
		
		model.addAttribute("clubRecord", record);		
		model.addAttribute("page", pageNum);
		model.addAttribute("club_fileList", fileList);
		
		return "/admin/"+table+"_view";
	}
	
	@RequestMapping("/admin/clubWrite")
	public String clubWrite(@RequestParam(required=false) Integer num, Model model) { 
		
		// num(수정할 게시물 번호)이 있는 경우는 수정, 없는 경우는 쓰기
		if(num == null) {
			model.addAttribute("clubRecord", new ClubRecord()); // SessionAttributes의 record를 초기화한다.
			model.addAttribute("club_fileList", new ArrayList<EncodedFile>());
			return "/admin/"+table+"_write";
		} else {
			model.addAttribute("sqlType", "update");
			model.addAttribute("num", num);
			return "/admin/"+table+"_write";
		}
	}
	
	@RequestMapping(value="/admin/clubWrite", method=RequestMethod.POST)
	public String clubWrite(ClubRecord record, @RequestParam(required=false) String sqlType, 
									@RequestParam(required=false) Integer num, MultipartHttpServletRequest request, RedirectAttributes redirect, Model model) {
		
	    ResponStatus respon = new ResponStatus(true, "");
		String writer = memberDao.getAdminMemberInfo().getName();
		record.setWriter(writer); 			
		record.setTitle("제목없음");        
	   	record.setBbsId(table);            
	   	record.setBbsName(table_ko);
		
		// 수정 페이지에서의 요청이면 update
		if(sqlType != null) {
			record.setNum(num);
			respon = boardService.updateClubRecord(record, request);
		} else {
			respon = boardService.insertClubRecord(record, request);
		}
		
		// 실패했을 경우
		if(respon.isStatus() == false) {
			model.addAttribute("respon", respon);
			model.addAttribute("clubRecord", record);
			// 수정 페이지인 경우 추가로 리턴
			model.addAttribute("sqlType",sqlType);
			model.addAttribute("num",num);
			return "/admin/"+table+"_write";
		}
		
		if(sqlType == null) {
			respon = new ResponStatus(true, insert_s_msg);
			redirect.addFlashAttribute("respon", respon);
			return "redirect:/admin/"+table;
		} else {
			respon = new ResponStatus(true, update_s_msg);
			redirect.addFlashAttribute("respon", respon);
			return "redirect:/admin/"+table;
		}
		
	}
	
	
	
}

