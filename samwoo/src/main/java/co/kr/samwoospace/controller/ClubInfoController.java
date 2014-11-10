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

import co.kr.samwoospace.bean.ClubInfoRecord;
import co.kr.samwoospace.bean.ClubRecord;
import co.kr.samwoospace.bean.EncodedFile;
import co.kr.samwoospace.bean.ResponStatus;
import co.kr.samwoospace.dao.memberDAO;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.service.FileService;
import co.kr.samwoospace.util.Paging;

@Controller
@SessionAttributes({"member","clubInfoRecord","clubInfo_fileList"})
public class ClubInfoController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="memberDAO")
	private memberDAO memberDao;
	
	@Resource(name="fileService")
	private FileService fileService;
	
	private static final String table = "clubInfo";
	private static final String table_ko = "동호회정보";
	
	private static final String insert_s_msg = "동호회정보 등록이 완료되었습니다.";
	private static final String update_s_msg = "동호회정보 수정이 완료되었습니다.";
	
	@RequestMapping("/admin/clubInfo")
	public String clubInfoList(@RequestParam(required=false) Integer pageNum, Model model) {
		if (pageNum == null) { pageNum = 1; }
	
		Paging paging = boardService.selectPagingInfo(table, "clubInfo", pageNum);
		List<ClubInfoRecord> clubInfoList = boardService.ListClubInfoRecord(paging);
		
		model.addAttribute("clubInfoList", clubInfoList);
		model.addAttribute("paging", paging.makePageGroup());
		
		return "/admin/clubInfo"; 
	}
	
	@RequestMapping("/admin/clubInfoView")
	public String clubView(@RequestParam Integer pageNum, @RequestParam int num, Model model) {
		
		if(pageNum == null) { pageNum = 1; }
		
		ClubInfoRecord record = boardService.selectOneClubInfoRecord(num);
		List<EncodedFile> fileList = fileService.selectFileInfo(table, num);
		//boardService.updateViewCount(table, num);
		
		model.addAttribute("clubInfoRecord", record);		
		model.addAttribute("page", pageNum);
		model.addAttribute("clubInfo_fileList", fileList);
		
		return "/admin/"+table+"_view";
	}
	
	@RequestMapping("/admin/clubInfoWrite")
	public String clubWrite(@RequestParam(required=false) Integer num, Model model) { 
		
		if(num == null) {
			model.addAttribute("clubInfoRecord", new ClubInfoRecord()); 
			model.addAttribute("clubInfo_fileList", new ArrayList<EncodedFile>());
			return "/admin/"+table+"_write";
		} else {
			model.addAttribute("sqlType", "update");
			model.addAttribute("num", num);
			return "/admin/"+table+"_write";
		}
	}
	
	@RequestMapping(value="/admin/clubInfoWrite", method=RequestMethod.POST)
	public String clubWrite(ClubInfoRecord record, @RequestParam(required=false) String sqlType, 
									@RequestParam(required=false) Integer num, MultipartHttpServletRequest request, RedirectAttributes redirect, Model model) {
		
	    ResponStatus respon = new ResponStatus(true, "");
		record.setBbsId(table);            
	   	record.setBbsName(table_ko);
	   	
		if(sqlType != null) {
			record.setNum(num);
			respon = boardService.updateClubInfoRecord(record, request);
		} else {
			respon = boardService.insertClubInfoRecord(record, request);
		}
		
	
		if(respon.isStatus() == false) {
			model.addAttribute("respon", respon);
			model.addAttribute("clubInfoRecord", record);
		
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

