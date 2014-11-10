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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.samwoospace.bean.EncodedFile;
import co.kr.samwoospace.bean.ResponStatus;
import co.kr.samwoospace.bean.TechRecord;
import co.kr.samwoospace.dao.memberDAO;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.service.FileService;
import co.kr.samwoospace.util.Paging;

@Controller
@SessionAttributes({"member","techRecord","tech_fileList"})
public class TechController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="memberDAO")
	private memberDAO memberDao;
	
	@Resource(name="fileService")
	private FileService fileService;
	
	private static final String table = "technology";
	private static final String table_ko = "특허/신기술";
	
	private static final String insert_s_msg = "특허/신기술 등록이 완료되었습니다.";
	private static final String update_s_msg = "특허/신기술 수정이 완료되었습니다.";
	
	
	@RequestMapping("/admin/technology")
	public String technologyList(@RequestParam(required=false) Integer pageNum, Model model) {
		if (pageNum == null) { pageNum = 1; }
	
		Paging paging = boardService.selectPagingInfo(table, "technology", pageNum);
		List<TechRecord> techList = boardService.ListTechRecord(paging);
		
		model.addAttribute("techList", techList);
		model.addAttribute("paging", paging.makePageGroup());
		
		return "/admin/technology"; 
	}
	
	@RequestMapping("/admin/techView")
	public String techView(@RequestParam Integer pageNum, @RequestParam int num, Model model) {
		
		if (pageNum == null) { pageNum = 1; }
		
		TechRecord record = boardService.selectOneTechRecord(num);
		List<EncodedFile> fileList = fileService.selectFileInfo(table, num);
		boardService.updateViewCount(table, num);
		
		model.addAttribute("techRecord", record);		
		model.addAttribute("page", pageNum);
		model.addAttribute("tech_fileList", fileList);
		
		return "/admin/"+table+"_view";
	}
	
	@RequestMapping("/admin/techWrite")
	public String techWrite(@RequestParam(required=false) Integer num, SessionStatus status, Model model) { 
		
	
		if(num == null) {
			status.setComplete();
			model.addAttribute("techRecord", new TechRecord()); // SessionAttributes�� record�� �ʱ�ȭ�Ѵ�.
			model.addAttribute("tech_fileList", new ArrayList<EncodedFile>());
			return "/admin/"+table+"_write";
		} else {
			model.addAttribute("sqlType", "update");
			model.addAttribute("num", num);
			return "/admin/"+table+"_write";
		}
	}
	
	@RequestMapping(value="/admin/techWrite", method=RequestMethod.POST)
	public String techWrite(TechRecord record, @RequestParam(required=false) String sqlType, 
									@RequestParam(required=false) Integer num, MultipartHttpServletRequest request, RedirectAttributes redirect, Model model) {
		
	    ResponStatus respon = new ResponStatus(true, "");
	    String writer = memberDao.getAdminMemberInfo().getName();
		
		record.setWriter(writer);
		record.setContents("내용없음");
		record.setBbsId(table);
		record.setBbsName(table_ko);
		
	
		if(sqlType != null) {
			record.setNum(num);
			respon = boardService.updateTechRecord(record, request);
		} else {
			respon = boardService.insertTechRecord(record, request);
		}
		
	
		if(respon.isStatus() == false) {
			model.addAttribute("respon", respon);
			model.addAttribute("techRecord", record);

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