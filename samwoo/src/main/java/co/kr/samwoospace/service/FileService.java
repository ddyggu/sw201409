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
	
	/**
	 * 파일 업로드 요청을 처리하는 메소드<br/>
	 * <br/>
	 * @param request - Multipart/Form-data 요청을 담고 있는 객체<br/>
	 * @param num - SQL Server의 @@Identity 값 (게시물 번호)<br/>
	 * @param bbsId - 게시판이름(DB table이름)<br/>
	 * @param moreThanOne - true일 경우 복수 파일 업로드 가능<br/>
	 * @return ReponStatus - 요청이 성공적으로 수행됐는지 결과 여부(true일 경우 성공) */
	ResponStatus FileUpload(MultipartHttpServletRequest request, int num, String bbsId, boolean moreThanOne);
	
	/**
	 * 스마트에디터 사진 업로드 요청을 처리하는 메소드
	 * <br/>
	 * @param file - 스마트에디터 사진업로드 폼의 Multipart/Form-data 요청을 담고 있는 객체<br/>
	 * @param uploadPath - 에디터 사진 업로드 경로(/resources/editorUpload)
	 * @param fileName - 변환된 파일이름
	 */
	void locateFileOnServer(MultipartFile file, String uploadPath, String fileName);
	
	void deleteLocatedFileOnServer(String fileName);
	
	void deleteFileByBoardNum(String bbsId, int boardNum);
	
	void deleteFileByFileNum(int num);


}