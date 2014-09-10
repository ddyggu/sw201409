package co.kr.samwoospace.dao;

import java.util.List;
import java.util.Map;

import co.kr.samwoospace.bean.EncodedFile;

public interface fileDAO {
	
	List<EncodedFile> selectFileInfo(Map<String,Object> paramMap);
	EncodedFile selectFileInfoByFileNum(int filenum);
	EncodedFile selectFileInfoByType(EncodedFile encodeFile);

	void insertFileName(EncodedFile file);
		
	void deleteFileByBoardNum(String bbsId, int boardNum);
	void deleteFileByFileNum(int num);
}
