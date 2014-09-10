package co.kr.samwoospace.controller;

import java.io.File;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.kr.samwoospace.bean.EncodedFile;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.service.FileService;
import co.kr.samwoospace.util.StringUtility;

/**
 * 파일 업로드 및 다운로드 요청을 처리하는 컨트롤러,<br/>
 * Multipart form을 이용한 첨부파일 업로드 요청은<br/> 
 * 서비스(co.kr.samwoospace.service.fileService)에서 처리함<br/>
 * <br/>
 * @author roscoe
 *
 */

@Controller
public class FileController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="fileService")
	private FileService fileService;
	
	@Resource(name="stringUtility")
	private StringUtility stringUtil;
	
	@RequestMapping(value="/fileDelete", method=RequestMethod.GET, produces="text/plain;charset=utf-8")
	public void fileDelete(@RequestParam int num, HttpServletResponse response) {
		// 파일번호(identity)로 조회하여 파일정보 획득
		EncodedFile file = fileService.selectFileInfoByFileNum(num);
		// DB삭제처리
		fileService.deleteFileByFileNum(file.getNum());
		// 업로드 폴더에서 삭제처리
		fileService.deleteLocatedFileOnServer(file.getEncodedFileName());
	}
	
	@RequestMapping(value="/admin/download", method=RequestMethod.GET, produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public FileSystemResource download(@RequestParam String name) {
		
		File file = new File(stringUtil.getUploadPath());
		return new FileSystemResource(file);
	}
	
	@RequestMapping(value="/admin/editorUpload", method=RequestMethod.POST) 
	public String editorUpload(MultipartHttpServletRequest request, HttpServletResponse response, Model model) {
	
		MultipartFile file = request.getFile("Filedata");
		String callback = request.getParameter("callback_func");
	
		String oName = file.getOriginalFilename();
		String fileName = stringUtil.encodedFileName(oName);
		String uploadPath = stringUtil.getEditorUploadPath();
		
		fileService.locateFileOnServer(file, uploadPath, fileName);
		response.setStatus(HttpServletResponse.SC_OK);
	
		model.addAttribute("oName" , oName);
		model.addAttribute("fileName", fileName);
		model.addAttribute("uploadPath", uploadPath);
		model.addAttribute("callback_func", callback);
	
		return "/se_editor/photo_uploader/popup/callback";
	}
}
