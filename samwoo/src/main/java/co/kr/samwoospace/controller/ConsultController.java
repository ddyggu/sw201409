package co.kr.samwoospace.controller;

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

import co.kr.samwoospace.bean.ConsultRecord;
import co.kr.samwoospace.bean.EncodedFile;
import co.kr.samwoospace.bean.Member;
import co.kr.samwoospace.bean.ResponStatus;
import co.kr.samwoospace.dao.memberDAO;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.service.FileService;
import co.kr.samwoospace.util.Paging;

@Controller
@SessionAttributes({"member","consultRecord","consult_fileList"})
public class ConsultController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="memberDAO")
	private memberDAO memberDao;
	
	@Resource(name="fileService")
	private FileService fileService;
	
	private static final String table = "consult";
	private static final String table_ko = "고객문의";
	
	private static final String insert_s_msg = "고객문의 등록이 완료되었습니다.";
	private static final String update_s_msg = "고객문의 답변이 등록되었습니다.";
	
	@RequestMapping("/admin/consult")
	public String consultList(@RequestParam(required=false) Integer pageNum, Model model) {
		if (pageNum == null) { pageNum = 1; }
	
		Paging paging = boardService.selectPagingInfo(table, "consult", pageNum);
		List<ConsultRecord> consultList = boardService.ListConsultRecord(paging);
		
		model.addAttribute("consultList", consultList);
		model.addAttribute("paging", paging.makePageGroup());
		
		return "/admin/consult"; 
	}
	
	@RequestMapping("/admin/consultView")
	public String consultView(@RequestParam Integer pageNum, @RequestParam int num, Model model) {
		
		if(pageNum == null) { pageNum = 1; }
		
		ConsultRecord record = boardService.selectOneConsultRecord(num);
		List<EncodedFile> fileList = fileService.selectFileInfo(table, num);
		boardService.updateViewCount(table, num);
		
		model.addAttribute("consultRecord", record);		
		model.addAttribute("page", pageNum);
		model.addAttribute("consult_fileList", fileList);
		
		return "/admin/"+table+"_view";
	}
	
	@RequestMapping(value="/admin/questionWrite", method=RequestMethod.POST)
	public String questionWrite(ConsultRecord record, MultipartHttpServletRequest request, RedirectAttributes redirect) {
			
		record.setBbsId("consult");       
		record.setBbsName("고객문의");
		
		boardService.insertConsultRecord(record, request);
		redirect.addFlashAttribute("respon", new ResponStatus(true, insert_s_msg));
		
		return "redirect:/community04";
	}
	
	
	@RequestMapping(value="/admin/answerConsult", method=RequestMethod.POST)
	public String consultAnswer(ConsultRecord record, RedirectAttributes redirect) {
			Member member = memberDao.getAdminMemberInfo();
			record.setA_writer(member.getName());
			
			boardService.updateConsultAnswer(record);
			redirect.addFlashAttribute("respon", new ResponStatus(true, update_s_msg));
			
			return "redirect:/admin/"+table;
	}
	
}
