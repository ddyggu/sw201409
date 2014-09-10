package co.kr.samwoospace.controller;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.kr.samwoospace.bean.BoardRecord;
import co.kr.samwoospace.bean.ConsultRecord;
import co.kr.samwoospace.bean.EncodedFile;
import co.kr.samwoospace.bean.FaqRecord;
import co.kr.samwoospace.bean.Param;
import co.kr.samwoospace.bean.RecruitRecord;
import co.kr.samwoospace.bean.ResultRecord;
import co.kr.samwoospace.bean.TechRecord;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.service.FileService;
import co.kr.samwoospace.util.Paging;

@Controller
public class MenuController {
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="fileService")
	private FileService fileService;
	
	
	@RequestMapping(value="/")
	public String findindex(Device device) {
		if(device.isMobile()) { return "m/index_m";
		} else { return "/index"; }
	}
	
	@RequestMapping(value="/about01")
	public String findAbout1(Device device, @RequestParam(required=false) Integer m, Model model) {
		model.addAttribute("m", m);
		if(device.isMobile()) { return "m/about01_m";
		} else { return "/about01"; }
	}
	
	@RequestMapping(value="/about02")
	public String findAbout2(Device device, @RequestParam(required=false) Integer m, Model model) {
		model.addAttribute("m", m);
		if(device.isMobile()) { return "m/about02_m";
		} else { return "/about02";  }
	}
	
	@RequestMapping(value="/about03")
	public String findAbout3(Device device, @RequestParam(required=false) Integer m, Model model) {
		model.addAttribute("m", m);
		if(device.isMobile()) { return "m/about03_m";
		} else { return "/about03"; }
	}
	
	@RequestMapping(value="/about04")
	public String findAbout4(Device device,@RequestParam(required=false) Integer pageNum, @RequestParam(required=false) Integer m, Model model) {
		
		if(device.isMobile()) { 
			
			if(pageNum == null) { pageNum = 1; }
			
			Paging paging = boardService.selectPagingInfo("technology", "/about04", pageNum);
			List<TechRecord> techList = boardService.ListTechRecord(paging);
			
			model.addAttribute("techList", techList);
			model.addAttribute("paging", paging.makePageGroup());
			model.addAttribute("m", m);
			
			return "m/about04_m";
		} else { 
			return  "/about04";
		}
	}
	
	@RequestMapping(value="/about07")
	public String about07(@RequestParam(required=false) Integer pageNum, @RequestParam(required=false) Integer m, Model model) {
		
		if(pageNum == null) { pageNum = 1; }
		
		Paging paging = boardService.selectPagingInfo("technology", "/about07", pageNum);
		List<TechRecord> techList = boardService.ListTechRecord(paging);
		
		model.addAttribute("techList", techList);
		model.addAttribute("paging", paging.makePageGroup());
		model.addAttribute("m", m);
		
		return  "/about07";
	}
	
	@RequestMapping(value="/project01")
	public String findProject1(Device device) {
		
		if(device.isMobile()) { return "m/project01_m";
		} else { return "/project"; }
	}
	
	@RequestMapping(value="/project02")
	public String findProject2(Device device) {
		if(device.isMobile()) { return "m/project02_m"; 
		} else { return "/project"; }
	}
	
	@RequestMapping(value="/project03")
	public String findProject3(Device device) {
		if(device.isMobile()) { return "m/project03_m";  
		} else { return "/project";}
	}
	
	@RequestMapping(value="/service01")
	public String findService1(Device device, @RequestParam(required=false) Integer m, Model model) {
		model.addAttribute("m", m);
		if(device.isMobile()) { return "m/service01_m";
		} else { return "/service01";   }
	}
	
	@RequestMapping(value="/service02")
	public String findService2(Device device, @RequestParam(required=false) Integer m, Model model) {
		model.addAttribute("m", m);
		if(device.isMobile()) { return "m/service02_m";   
		} else { return "/service02"; }
	}
	
	@RequestMapping(value="/service03")
	public String findService3(Device device, @RequestParam(required=false) Integer m, Model model) {
		model.addAttribute("m", m);
		if(device.isMobile()) { return "m/service03_m";   
		} else { return "/service03"; }
	}
	
	@RequestMapping(value="/service04")
	public String findService4(Device device, @RequestParam(required=false) Integer m, Model model) {
		model.addAttribute("m", m);
		if(device.isMobile()) { return "m/service04_m";   
		} else { return "/service04"; }
	}
	
	
	
	@RequestMapping(value="/project")
	public String project(@RequestParam(required=false) Integer pageNum, @RequestParam(required=false) Integer m, @RequestParam(required=false) Integer num, Model model) {
		
		if(pageNum == null) { pageNum = 1; }
		if(num == null) { num = 1; }
		
		Param<String,Object> param = new Param<String,Object>();
		param.put("num", num);
		
		Paging paging = boardService.selectPagingInfoByCondition("result", "/project", pageNum, 9, param);
		List<ResultRecord> resultList = boardService.ListResultRecord(paging);
		
		model.addAttribute("resultList",  resultList);
		model.addAttribute("paging", paging.makePageGroup());
		model.addAttribute("m", m);
		
		return  "/project";
	}
	
	@RequestMapping("/career01") 
	public String career01(Device device, @RequestParam(required=false) Integer m, @RequestParam(required=false) Integer pageNum, Model model) {
		if(pageNum == null) { pageNum = 1; }
		
		Param<String,Object> param = new Param<String,Object>();
		Paging paging = boardService.selectPagingInfoByCondition("recruit", "/career01", pageNum, 10, param);
		
		List<RecruitRecord> recruitList  = boardService.ListRecruitRecord(paging);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		for(RecruitRecord re : recruitList) {
			Date endDate = null;
			try {
				endDate = format.parse(re.getEndDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date currentDate = new Date();
			int result = currentDate.compareTo(endDate);
			
			if(result == 1) {
				re.setIsEnd("모집마감");
			} else {
				re.setIsEnd("모집중");
			}
		}

		model.addAttribute("recruitRecord", recruitList);
		model.addAttribute("paging", paging.makePageGroup());
		model.addAttribute("m", m);
		
		if(device.isMobile()) {
			return "m/career01_m";
		} else {
			return "/career01";
		}
	}
	
	@RequestMapping("/careerView")
	public String careerView(@RequestParam int num, @RequestParam(required=false) Integer pageNum, 
								   @RequestParam(required=false) Integer m, Model model) {
		
		if(pageNum == null) { pageNum = 1; }
		
		RecruitRecord record = boardService.selectOneRecruitRecord(num);
		List<EncodedFile> fileList = fileService.selectFileInfo("recruit", num);
		boardService.updateViewCount("recruit", num);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date endDate = null;
		try {
			endDate = format.parse(record.getEndDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date currentDate = new Date();
		int result = currentDate.compareTo(endDate);
		
		if(result == 1) {
			record.setIsEnd("모집마감");
		} else {
			record.setIsEnd("모집중");
		}
		
		model.addAttribute("recruitRecord", record);		
		model.addAttribute("page", pageNum);
		model.addAttribute("recruit_fileList", fileList);
		
		return "/career01_view";
	}
	
	
	@RequestMapping("/career02")
	public String career02(@RequestParam(required=false) Integer m, Model model) {
		model.addAttribute("m", m);
		return "/career02";
	}
	
	@RequestMapping("/career03")
	public String career03(@RequestParam(required=false) Integer m, Model model) {
		model.addAttribute("m", m);
		return "/career03";
	}
	
	@RequestMapping("/community01")
	public String community01(@RequestParam(required=false) Integer pageNum, @RequestParam(required=false) Integer m, Model model) {
		if(pageNum == null) { pageNum = 1; }
		
		Param<String,Object> param = new Param<String,Object>();
	    Paging paging = boardService.selectPagingInfoByCondition("notice", "/community01", pageNum, 10, param);
	    List<BoardRecord> noticeList = boardService.ListBoardRecord(paging);
	    
		model.addAttribute("noticeRecord", noticeList);
		model.addAttribute("paging", paging.makePageGroup());
		model.addAttribute("m", m);
		
		return "/community01";
	}
	
	@RequestMapping("/community02")
	public String community02(@RequestParam(required=false) Integer m, Model model) {
		model.addAttribute("m", m);
		return "/career03";
	}
	
	@RequestMapping("/community03")
	public String community03(@RequestParam(required=false) Integer pageNum, Model model, @RequestParam(required=false) Integer m) {
		if(pageNum == null) { pageNum = 1; }
		
		Param<String,Object> param = new Param<String,Object>();
		Paging paging = boardService.selectPagingInfoByCondition("faq", "/community03", pageNum, 10, param);
		List<FaqRecord> faqList = boardService.ListFaqRecord(paging);
		
		model.addAttribute("faqRecord", faqList);		
		model.addAttribute("page", pageNum);
		model.addAttribute("m", m);
		
		return "/community03";
	}
	
	@RequestMapping("/community04")
	public String community04(@RequestParam(required=false) Integer pageNum, Model model, @RequestParam(required=false) Integer m) {
		if(pageNum == null) { pageNum = 1; }
		
		Param<String,Object> param = new Param<String,Object>();
		Paging paging = boardService.selectPagingInfoByCondition("consult", "/community04", pageNum, 10, param);
		List<ConsultRecord> consultList = boardService.ListConsultRecord(paging);
		
		model.addAttribute("consultRecord", consultList);		
		model.addAttribute("page", pageNum);
		model.addAttribute("m", m);
		
		return "/community04";
	}
	
	@RequestMapping("/community05")
	public String community05(@RequestParam(required=false) Integer m, Model model) {
		model.addAttribute("m", m);
		return "/community05";
	}
	
	@RequestMapping("/community01_view")
	public String community01_View(@RequestParam Integer num, @RequestParam(required=false) Integer pageNum, Model model) {
		
		if(pageNum == null) { pageNum = 1; }
		
		BoardRecord record = boardService.selectOneBoardRecord(num);
		List<EncodedFile> fileList = fileService.selectFileInfo("notice", num);
		boardService.updateViewCount("notice", num);
		
		model.addAttribute("noticeRecord", record);		
		model.addAttribute("page", pageNum);
		model.addAttribute("notice_fileList", fileList);
		
		return "/community01_view";
	}
	
	
	
	@RequestMapping("/community04_view")
	public String community04_view(@RequestParam Integer num, @RequestParam(required=false) Integer pageNum, Model model) {
		if(pageNum == null) { pageNum = 1; }
		
		ConsultRecord record = boardService.selectOneConsultRecord(num);
		List<EncodedFile> fileList = fileService.selectFileInfo("consult", num);
		boardService.updateViewCount("consult", num);
		
		model.addAttribute("record", record);		
		model.addAttribute("page", pageNum);
		model.addAttribute("consult_fileList", fileList);
		
		return "/community04_view";
	}
	
}
