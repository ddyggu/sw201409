package co.kr.samwoospace.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.kr.samwoospace.bean.EncodedFile;
import co.kr.samwoospace.bean.ResponStatus;

public interface FileService {
	
	List<EncodedFile> selectFileInfo(String bbsId, int boardNum);
	
	EncodedFile selectFileInfoByType(EncodedFile encodeFile);
	
	EncodedFile selectFileInfoByFileNum(int filenum);
	
	ResponStatus FileUpload(MultipartHttpServletRequest request, int num, String bbsId, boolean moreThanOne);
	
	void locateFileOnServer(MultipartFile file, String uploadPath, String fileName);
	
	void deleteLocatedFileOnServer(String fileName);
	
	void deleteFileByBoardNum(String bbsId, int boardNum);
	
	void deleteFileByFileNum(int num);


}