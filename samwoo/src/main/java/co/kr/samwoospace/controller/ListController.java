package co.kr.samwoospace.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.samwoospace.bean.ResponStatus;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.service.FileService;

/**
 * 관리자 메뉴의 리스트 페이지 컨트롤러<br/>
 * (전 메뉴 공통)<br/>
 * <br/>
 * co.kr.samwoospace.bean.bbsName과 DB Table name과 1:1 
 * 
 * @author roscoe
 */

@Controller
@SessionAttributes({"member", "record"})
public class ListController {
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="fileService")
	private FileService fileService;
	
	/**
	 * 관리자 메뉴의 리스트 페이지를 관리하는 컨트롤러<br/>
	 * (전 메뉴 공통)<br/>
	 * 
	 * @param bbsId - 게시판명 (DB테이블명과 매칭)
	 * @param pageNum - 요청되는 페이지 번호
	 * @param model - view로 리턴되는 모델값
	 * @return
	 */
	@RequestMapping(value="/admin/board")
	public String BoardList(@RequestParam String bbsId, @RequestParam(required=false) Integer pageNum, Model model) {
		/*
		Search<String,Object> search = new Search<String,Object>();
		ListModel listModel = boardService.selectList(bbsId, pageNum, search);
		
		model.addAttribute("listModel", listModel);
		model.addAttribute("paging", listModel.getPagingTag());
		
		return listModel.getListPage();
		*/
		return null;
	}
	
	/**
	 * 관리자 메뉴의 리스트 페이지 삭제 요청을 처리하는 컨트롤러<br/>
	 * <br/>
	 * @param boardNum - 체크박스에 체크로 삭제 요청받은 게시물의 번호들<br/>
	 * 							   ("게시판ID"&"게시물번호" , "게시판ID"&"게시물번호"의 형태로 구분됨)<br/>
	 * @return
	 */
	@RequestMapping(value="/admin/delete")
	public String BoardDelete(@RequestParam String boardNum, RedirectAttributes redirect) {
		String[] requiredRecord = boardNum.split(",");
		String bbsId = null;
		
		for(String record : requiredRecord) {
			int border = record.indexOf("&");
			
			bbsId = record.substring(0, border);
			String tmp = record.substring(border+1, record.length());
			int num = Integer.parseInt(tmp);
			
			boardService.deleteRecord(bbsId, num);
			fileService.deleteFileByBoardNum(bbsId, num);
		
		}
		
		ResponStatus respon = new ResponStatus(true, "삭제가 완료되었습니다.");
		redirect.addFlashAttribute("respon", respon);
		return "redirect:/admin/board?bbsId="+bbsId;
	}
}
