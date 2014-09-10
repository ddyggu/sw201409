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
	 * ���� ���ε� ��û�� ó���ϴ� �޼ҵ�<br/>
	 * <br/>
	 * @param request - Multipart/Form-data ��û�� ��� �ִ� ��ü<br/>
	 * @param num - SQL Server�� @@Identity �� (�Խù� ��ȣ)<br/>
	 * @param bbsId - �Խ����̸�(DB table�̸�)<br/>
	 * @param moreThanOne - true�� ��� ���� ���� ���ε� ����<br/>
	 * @return ReponStatus - ��û�� ���������� ����ƴ��� ��� ����(true�� ��� ����) */
	ResponStatus FileUpload(MultipartHttpServletRequest request, int num, String bbsId, boolean moreThanOne);
	
	/**
	 * ����Ʈ������ ���� ���ε� ��û�� ó���ϴ� �޼ҵ�
	 * <br/>
	 * @param file - ����Ʈ������ �������ε� ���� Multipart/Form-data ��û�� ��� �ִ� ��ü<br/>
	 * @param uploadPath - ������ ���� ���ε� ���(/resources/editorUpload)
	 * @param fileName - ��ȯ�� �����̸�
	 */
	void locateFileOnServer(MultipartFile file, String uploadPath, String fileName);
	
	void deleteLocatedFileOnServer(String fileName);
	
	void deleteFileByBoardNum(String bbsId, int boardNum);
	
	void deleteFileByFileNum(int num);


}