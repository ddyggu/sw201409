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
 * 관리자 메뉴 수행실적(result) 요청처리 담당 컨트롤러<br/>
 * 수행실적 List 관련 요청은 ListController에서 공통으로 처리함<br/>
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
	private static final String table_ko = "수행실적";
	
	private static final String insert_s_msg = "수행실적 등록이 완료되었습니다.";
	private static final String update_s_msg = "수행실적 수정이 완료되었습니다.";
	
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
		
		// num(수정할 게시물 번호)이 있는 경우는 수정, 없는 경우는 쓰기
		if(num == null) {
			model.addAttribute("resultRecord", new ResultRecord()); // SessionAttributes의 record를 초기화한다.
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
		record.setContents("내용없음");
		record.setBbsId(table);
		record.setBbsName(table_ko);
		
		// 수정 페이지에서의 요청이면 update
		if(sqlType != null) {
			record.setNum(num);
			respon = boardService.updateResultRecord(record, request);
		} else {
			respon = boardService.insertResultRecord(record, request);
		}
		
		// 실패했을 경우
		if(respon.isStatus() == false) {
			// 뷰로 입력정보 리턴
			model.addAttribute("respon", respon);
			model.addAttribute("resultRecord", record);
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
