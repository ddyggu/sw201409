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
import co.kr.samwoospace.bean.ResponStatus;
import co.kr.samwoospace.bean.ResultRecord;
import co.kr.samwoospace.dao.memberDAO;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.service.FileService;
import co.kr.samwoospace.util.Paging;

/**
 * ������ �޴� �������(result) ��ûó�� ��� ��Ʈ�ѷ�<br/>
 * ������� List ���� ��û�� ListController���� �������� ó����<br/>
 * <br/>
 * @author roscoe
 *
 */

@Controller
@SessionAttributes({"member","resultRecord","result_fileList"})
public class ResultController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="memberDAO")
	private memberDAO memberDao;
	
	@Resource(name="fileService")
	private FileService fileService;
	
	private static final String table = "result";
	private static final String table_ko = "�������";
	
	private static final String insert_s_msg = "������� ����� �Ϸ�Ǿ����ϴ�.";
	private static final String update_s_msg = "������� ������ �Ϸ�Ǿ����ϴ�.";
	
	@RequestMapping("/admin/result")
	public String resultList(@RequestParam(required=false) Integer pageNum, Model model) {
		if (pageNum == null) { pageNum = 1; }
	
		Paging paging = boardService.selectPagingInfo(table, "result", pageNum);
		List<ResultRecord> resultList = boardService.ListResultRecord(paging);
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("paging", paging.makePageGroup());
		
		return "/admin/result"; 
	}
	
	@RequestMapping("/admin/resultView")
	public String resultView(@RequestParam Integer pageNum, @RequestParam int num, Model model) {
		
		if(pageNum == null) { pageNum = 1; }
		
		ResultRecord record = boardService.selectOneResultRecord(num);
		List<EncodedFile> fileList = fileService.selectFileInfo(table, num);
		boardService.updateViewCount(table, num);
		
		model.addAttribute("resultRecord", record);		
		model.addAttribute("page", pageNum);
		model.addAttribute("result_fileList", fileList);
		
		return "/admin/"+table+"_view";
	}
	
	@RequestMapping("/admin/resultWrite")
	public String resultWrite(@RequestParam(required=false) Integer num, Model model) { 
		
		// num(������ �Խù� ��ȣ)�� �ִ� ���� ����, ���� ���� ����
		if(num == null) {
			model.addAttribute("resultRecord", new ResultRecord()); // SessionAttributes�� record�� �ʱ�ȭ�Ѵ�.
			model.addAttribute("result_fileList", new ArrayList<EncodedFile>());
			return "/admin/"+table+"_write";
		} else {
			model.addAttribute("sqlType", "update");
			model.addAttribute("num", num);
			return "/admin/"+table+"_write";
		}
	}
	
	@RequestMapping(value="/admin/resultWrite", method=RequestMethod.POST)
	public String resultWrite(ResultRecord record, @RequestParam(required=false) String sqlType, 
									@RequestParam(required=false) Integer num, MultipartHttpServletRequest request, RedirectAttributes redirect, Model model) {
		
	    ResponStatus respon = new ResponStatus(true, "");
	    String writer = memberDao.getAdminMemberInfo().getName();
		record.setWriter(writer);
		record.setContents("�������");
		record.setBbsId(table);
		record.setBbsName(table_ko);
		
		// ���� ������������ ��û�̸� update
		if(sqlType != null) {
			record.setNum(num);
			respon = boardService.updateResultRecord(record, request);
		} else {
			respon = boardService.insertResultRecord(record, request);
		}
		
		// �������� ���
		if(respon.isStatus() == false) {
			// ��� �Է����� ����
			model.addAttribute("respon", respon);
			model.addAttribute("resultRecord", record);
			// ���� �������� ��� �߰��� ����
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
