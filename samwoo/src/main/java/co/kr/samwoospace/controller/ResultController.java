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
import co.kr.samwoospace.bean.Param;
import co.kr.samwoospace.bean.ResponStatus;
import co.kr.samwoospace.bean.ResultRecord;
import co.kr.samwoospace.bean.Category;
import co.kr.samwoospace.dao.memberDAO;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.service.FileService;
import co.kr.samwoospace.util.Paging;


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
	public String resultList(@RequestParam(defaultValue="All") String division, @RequestParam(defaultValue="All") String category, 
							 @RequestParam(required=false) String searchWord, @RequestParam(required=false) Integer pageNum, Model model) {
		if (pageNum == null) { pageNum = 1; }
	
		
		Param<String,Object> param = new Param<String,Object>();
		param.put("division", division);
		param.put("category", category);
		if(searchWord != null && searchWord.equals("") == false) {
			System.out.println(searchWord);
			param.put("searchWord", searchWord);
		}
		
		Paging paging = boardService.selectPagingInfoByCondition(table, "result", pageNum, 10, param);
		List<ResultRecord> resultList = boardService.ListResultRecord(paging);
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("paging", paging.makePageGroup());
		model.addAttribute("division", division);
		model.addAttribute("category", category);
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
		
		
		if(num == null) {
			model.addAttribute("resultRecord", new ResultRecord()); 
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
		String category_name = Category.valueOf(record.getCategory()).getName();
	    
	    record.setWriter(writer);
		record.setCategory_name(category_name);
	    record.setBbsId(table);
		record.setBbsName(table_ko);
		
		
		if(sqlType != null) {
			record.setNum(num);
			respon = boardService.updateResultRecord(record, request);
		} else {
			respon = boardService.insertResultRecord(record, request);
		}
		

		if(respon.isStatus() == false) {
		
			model.addAttribute("respon", respon);
			model.addAttribute("resultRecord", record);
		
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
