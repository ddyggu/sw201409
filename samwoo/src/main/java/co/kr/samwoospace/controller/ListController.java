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
 * ������ �޴��� ����Ʈ ������ ��Ʈ�ѷ�<br/>
 * (�� �޴� ����)<br/>
 * <br/>
 * co.kr.samwoospace.bean.bbsName�� DB Table name�� 1:1 
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
	 * ������ �޴��� ����Ʈ �������� �����ϴ� ��Ʈ�ѷ�<br/>
	 * (�� �޴� ����)<br/>
	 * 
	 * @param bbsId - �Խ��Ǹ� (DB���̺��� ��Ī)
	 * @param pageNum - ��û�Ǵ� ������ ��ȣ
	 * @param model - view�� ���ϵǴ� �𵨰�
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
	 * ������ �޴��� ����Ʈ ������ ���� ��û�� ó���ϴ� ��Ʈ�ѷ�<br/>
	 * <br/>
	 * @param boardNum - üũ�ڽ��� üũ�� ���� ��û���� �Խù��� ��ȣ��<br/>
	 * 							   ("�Խ���ID"&"�Խù���ȣ" , "�Խ���ID"&"�Խù���ȣ"�� ���·� ���е�)<br/>
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
		
		ResponStatus respon = new ResponStatus(true, "������ �Ϸ�Ǿ����ϴ�.");
		redirect.addFlashAttribute("respon", respon);
		return "redirect:/admin/board?bbsId="+bbsId;
	}
}
