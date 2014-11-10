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

import co.kr.samwoospace.bean.EncodedFile;
import co.kr.samwoospace.bean.RecruitRecord;
import co.kr.samwoospace.bean.ResponStatus;
import co.kr.samwoospace.dao.memberDAO;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.service.FileService;
import co.kr.samwoospace.util.Paging;


@Controller
@SessionAttributes({"member","recruitRecord","recruit_fileList"})
public class RecruitController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="memberDAO")
	private memberDAO memberDao;
	
	@Resource(name="fileService")
	private FileService fileService;
	
	private static final String table = "recruit";
	private static final String table_ko = "채용공고";
	
	private static final String insert_s_msg = "채용공고 등록이 완료되었습니다.";
	private static final String update_s_msg = "채용공고 수정이 완료되었습니다.";
	
	@RequestMapping("/admin/recruit")
	public String popupList(@RequestParam(required=false) Integer pageNum, Model model) {
		if (pageNum == null) { pageNum = 1; }
	
		Paging paging = boardService.selectPagingInfo(table, "recruit", pageNum);
		List<RecruitRecord> recruitList = boardService.ListRecruitRecord(paging);
		
		model.addAttribute("recruitList", recruitList);
		model.addAttribute("paging", paging.makePageGroup());
		
		return "/admin/recruit"; 
	}
	
	@RequestMapping("/admin/recruitView")
	public String recruitView(@RequestParam Integer pageNum, @RequestParam int num, Model model) {
		
		if(pageNum == null) { pageNum = 1; }
		
		RecruitRecord record = boardService.selectOneRecruitRecord(num);
		List<EncodedFile> fileList = fileService.selectFileInfo(table, num);
		boardService.updateViewCount(table, num);
		
		model.addAttribute("recruitRecord", record);		
		model.addAttribute("page", pageNum);
		model.addAttribute("recruit_fileList", fileList);
		
		return "/admin/"+table+"_view";
	}
	
	@RequestMapping("/admin/recruitWrite")
	public String recruitWrite(@RequestParam(required=false) Integer num, Model model) { 

		
		if(num == null) {
			model.addAttribute("recruitRecord", new RecruitRecord()); 
			model.addAttribute("recruit_fileList", new ArrayList<EncodedFile>());
			return "/admin/"+table+"_write";
		} else {
			model.addAttribute("sqlType", "update");
			model.addAttribute("num", num);
			return "/admin/"+table+"_write";
		}
	}
	
	@RequestMapping(value="/admin/recruitWrite", method=RequestMethod.POST)
	public String recruitWrite(RecruitRecord record, @RequestParam(required=false) String sqlType, @RequestParam(required=false) Integer num,
									MultipartHttpServletRequest request, RedirectAttributes redirect, Model model) {
		
	    ResponStatus respon = new ResponStatus(true, "");
	    String writer = memberDao.getAdminMemberInfo().getName();
	    record.setWriter(writer);
	    record.setBbsId(table);
	    record.setBbsName(table_ko);
	    
	    

		if(sqlType != null) {
			record.setNum(num);
			respon = boardService.updateRecruitRecord(record, request);
		} else {
			respon = boardService.insertRecruitRecord(record, request);
		}
		

		if(respon.isStatus() == false) {

			model.addAttribute("respon", respon);
			model.addAttribute("recruitRecord", record);

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

