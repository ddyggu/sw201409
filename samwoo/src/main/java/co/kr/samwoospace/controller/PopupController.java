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
import co.kr.samwoospace.bean.PopupRecord;
import co.kr.samwoospace.bean.ResponStatus;
import co.kr.samwoospace.dao.memberDAO;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.service.FileService;
import co.kr.samwoospace.util.Paging;

/**
 * 관리자 메뉴 팝업관리(popup) 요청처리 담당 컨트롤러<br/>
 * 팝업관리 List 관련 요청은 ListController에서 공통으로 처리함<br/>
 * <br/>
 * @author roscoe
 *
 */

@Controller
@SessionAttributes({"member","popupRecord","popup_fileList"})
public class PopupController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="memberDAO")
	private memberDAO memberDao;
	
	@Resource(name="fileService")
	private FileService fileService;
	
	private static final String table = "popup";
	private static final String table_ko = "팝업관리";
	
	private static final String insert_s_msg = "팝업 등록이 완료되었습니다.";
	private static final String update_s_msg = "팝업 수정이 완료되었습니다.";

	@RequestMapping("/admin/popup")
	public String popupList(@RequestParam(required=false) Integer pageNum, Model model) {
		if (pageNum == null) { pageNum = 1; }
	
		Paging paging = boardService.selectPagingInfo(table, "popup", pageNum);
		List<PopupRecord> popupList = boardService.ListPopupRecord(paging);
		
		model.addAttribute("popupList", popupList);
		model.addAttribute("paging", paging.makePageGroup());
		
		return "/admin/popup"; 
	}
	
	@RequestMapping("/admin/popupWrite")
	public String popupWrite(@RequestParam(required=false) Integer num, Model model) { 
		
		// num(수정할 게시물 번호)이 있는 경우는 수정, 없는 경우는 쓰기
		if(num == null) {
			model.addAttribute("popupRecord", new PopupRecord()); // SessionAttributes의 record를 초기화한다.
			model.addAttribute("popup_fileList", new ArrayList<EncodedFile>());
			return "/admin/"+table+"_write";
		} else {
			model.addAttribute("popupRecord", boardService.selectOnePopupRecord(num));
			model.addAttribute("popup_fileList", fileService.selectFileInfo("popup", num));
			model.addAttribute("sqlType", "update");
			model.addAttribute("num", num);
			return "/admin/"+table+"_write";
		}
	}
	
	@RequestMapping(value="/admin/popupWrite", method=RequestMethod.POST)
	public String popupWrite(PopupRecord record, @RequestParam(required=false) String sqlType, @RequestParam(required=false) Integer num,
									MultipartHttpServletRequest request, RedirectAttributes redirect, Model model) {
		
	    ResponStatus respon = new ResponStatus(true, "");
		record.setBbsId(table); record.setBbsName(table_ko);
		
		// 수정 페이지에서의 요청이면 update
		if(sqlType != null) {
			record.setNum(num);
			respon = boardService.updatePopupRecord(record, request);
		} else {
			respon = boardService.insertPopupRecord(record, request);
		}
		
		// 실패했을 경우
		if(respon.isStatus() == false) {
			model.addAttribute("respon", respon);
			model.addAttribute("popupRecord", record);
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

