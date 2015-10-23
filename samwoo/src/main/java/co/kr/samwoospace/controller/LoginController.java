package co.kr.samwoospace.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import co.kr.samwoospace.bean.LoginCheck;
import co.kr.samwoospace.bean.Member;
import co.kr.samwoospace.bean.ResponStatus;
import co.kr.samwoospace.dao.memberDAO;
import co.kr.samwoospace.service.*;
import co.kr.samwoospace.util.StringUtility;

@Controller
@SessionAttributes({"member"})
public class LoginController {
	
	@Resource(name="boardService")
	private BoardService boardService;
	@Resource(name="memberDAO")
	private memberDAO memberdao;
	@Resource(name="stringUtility")
	private StringUtility stringUtil;
	
	/*
	@RequestMapping(value="/admin/FileUpload", method=RequestMethod.POST)
	public void fileUpload(HttpServletRequest request, HttpServletResponse response) {
		
		if(!(request instanceof MultipartHttpServletRequest)) {
			String OriginalFileName = request.getHeader("file-name");
			try {
				OriginalFileName = URLDecoder.decode(OriginalFileName, "utf-8");
				System.out.println(OriginalFileName);
				String fileSize = request.getHeader("file-size");
				String fileType = request.getHeader("file-type");
				String fileCount = request.getHeader("file-count");
				String newName = stringUtil.encodedFileName(OriginalFileName);
				if(stringUtil.isIllegalExtension(OriginalFileName)) {
					
				}
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			InputStream input = null;
			FileOutputStream outStream = null;
			File file = new File("C:/Users/Public/test/");

			try {
				input = request.getInputStream();
				outStream = new FileOutputStream(file);
				
				byte[] data = new byte[1024]; 
                int length = 0; 

                while( (length = input.read(data)) != -1 ) { 
                        outStream.write(data, 0, length); 
                } 
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	*/
	
	@RequestMapping(value="/admin/loginConfirm", method=RequestMethod.POST) 
	public String adminLoginProcess(@RequestParam String id, @RequestParam String pass, Model model) {
		Member member = new Member(id, pass);
		LoginCheck check = new LoginCheck();
		
		Member inqueriedMember = memberdao.isAdminMember(member);
		if(inqueriedMember == null) {
			check.setCheck(false);
			check.setMessage("아이디나 비밀번호가 잘못되었습니다.");
			model.addAttribute("check", check);
			return "/admin/index";
		} else {
			model.addAttribute("member", member);
			return "redirect:/admin/notice";
		}
	}
	
	@RequestMapping(value="/admin/logout")
	public String logout(SessionStatus status) {
	    status.setComplete();
	    return "redirect:/";
	}
	
	@RequestMapping(value="/admin/manage")
	  public String adminManagement() {
		return "/admin/manage";
	}
	
	@RequestMapping(value="/admin/manage", method=RequestMethod.POST)
	  public String adminManagement(Member member, Model model) {
		member.setName("관리자");
		memberdao.updateAdminMember(member);
		model.addAttribute("member", member);
		model.addAttribute("respon", new ResponStatus(true, "어드민 정보가 변경되었습니다.")); 
		return "/admin/manage";
	}
	
}
