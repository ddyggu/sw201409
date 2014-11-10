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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.samwoospace.bean.EncodedFile;
import co.kr.samwoospace.bean.FaqRecord;
import co.kr.samwoospace.bean.ResponStatus;
import co.kr.samwoospace.dao.memberDAO;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.service.FileService;
import co.kr.samwoospace.util.Paging;


@Controller
@SessionAttributes({"member","faqRecord","faq_fileList"})
public class FaqController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="memberDAO")
	private memberDAO memberDao;
	
	@Resource(name="fileService")
	private FileService fileService;
	
	private static final String table = "faq";
	private static final String table_ko = "자주묻는질문";
	
	private static final String insert_s_msg = "FAQ 등록이 완료되었습니다.";
	private static final String update_s_msg = "FAQ 수정이 완료되었습니다.";
	
	@RequestMapping("/admin/faq")
	public String faqList(@RequestParam(required=false) Integer pageNum, Model model) {
		if (pageNum == null) { pageNum = 1; }
	
		Paging paging = boardService.selectPagingInfo(table, "faq", pageNum);
		List<FaqRecord> faqList = boardService.ListFaqRecord(paging);
		
		model.addAttribute("faqList", faqList);
		model.addAttribute("paging", paging.makePageGroup());
		
		return "/admin/faq"; 
	}
	
	
	@RequestMapping("/admin/faqView")
	public String faqView(@RequestParam Integer pageNum, @RequestParam int num, Model model) {
		
		if(pageNum == null) { pageNum = 1; }
		
		FaqRecord record = boardService.selectOneFaqRecord(num);
		List<EncodedFile> fileList = fileService.selectFileInfo(table, num);
		
		model.addAttribute("faqRecord", record);		
		model.addAttribute("page", pageNum);
		model.addAttribute("faq_fileList", fileList);
		
		return "/admin/"+table+"_view";
	}
	
	@RequestMapping("/admin/faqWrite")
	public String faqWrite(@RequestParam(required=false) Integer num, Model model) { 
		
		
		if(num == null) {
			model.addAttribute("faqRecord", new FaqRecord()); 
			model.addAttribute("faq_fileList", new ArrayList<EncodedFile>());
			return "/admin/"+table+"_write";
		} else {
			model.addAttribute("sqlType", "update");
			model.addAttribute("num", num);
			return "/admin/"+table+"_write";
		}
	}
	
	@RequestMapping(value="/admin/faqWrite", method=RequestMethod.POST)
	public String faqWrite(FaqRecord record, @RequestParam(required=false) String sqlType, 
									@RequestParam(required=false) Integer num, RedirectAttributes redirect, Model model) {
		
	    ResponStatus respon = new ResponStatus(true, "");
		

		if(sqlType != null) {
			record.setNum(num);
			boardService.updateFaqRecord(record);
		} else {
			boardService.insertFaqRecord(record, null);
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
