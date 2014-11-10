package co.kr.samwoospace.service;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.kr.samwoospace.bean.EncodedFile;
import co.kr.samwoospace.bean.Param;
import co.kr.samwoospace.bean.ResponStatus;
import co.kr.samwoospace.dao.fileDAO;
import co.kr.samwoospace.util.StringUtility;

public class FileServiceImpl implements FileService {
	
	@Resource(name="fileDAO")
	private fileDAO fileDao;
	
	@Resource(name="stringUtility")
	private StringUtility stringUtil;
	
	@Override
	public List<EncodedFile> selectFileInfo(String bbsId, int boardNum) {
		Param<String,Object> param = new Param<String,Object>();
		param.put("bbsId", bbsId);
		param.put("boardNum", boardNum);
		List<EncodedFile> fileList = fileDao.selectFileInfo(param);
		return fileList;
	}

	@Override
	public EncodedFile selectFileInfoByType(EncodedFile encodeFile) {
		EncodedFile encFile = fileDao.selectFileInfoByType(encodeFile);
		return encFile;
	}
	
	
	@Override
	@Transactional
	public ResponStatus FileUpload(MultipartHttpServletRequest request, int num, String bbsId, boolean moreThanOne) {
		ResponStatus respon = new ResponStatus(true, "");
		
		if(request != null) {
			Map<String, MultipartFile> fileMap = request.getFileMap();
			Iterator<String> keySet = fileMap.keySet().iterator();
			
			while(keySet.hasNext()) {
				String key = keySet.next();
				MultipartFile file = fileMap.get(key);
			
				String originalName = file.getOriginalFilename();
				String contentType = file.getContentType();
				String encodedName = null;
				
				if(originalName != null) {
					
					if(originalName.equals("") == false) {
						encodedName = stringUtil.encodedFileName(originalName);
						// 확장자 검사
						if(stringUtil.isIllegalExtension(originalName)) {
							respon.setStatus(false);
							respon.setMessage("업로드할 수 없는 파일입니다.("+originalName+")");
							continue;
						}

						// MimeType 검사
						if(stringUtil.isIllegalMimeType(contentType)) {
							respon.setStatus(false);
							respon.setMessage("업로드할 수 없는 형태의 파일입니다.("+originalName+")");
							continue;
						}
						
						EncodedFile encodeFile = new EncodedFile();
				
						encodeFile.setBbsId(bbsId);
						encodeFile.setBoardNum(num);
						encodeFile.setFileName(originalName);
						encodeFile.setEncodedFileName(encodedName);			
						encodeFile.setThumbUrl("/thumb_"+encodedName.replaceFirst("/", ""));
						
						// 복수 파일 업로드 허용 여부
						if(moreThanOne == false) {
							List<EncodedFile> fileList = this.selectFileInfo(bbsId, num);
							if(fileList.size() >= 1) {
								respon.setStatus(false);
								respon.setMessage("두 개 이상의 파일은 업로드 할 수 없습니다. \\n 이미 업로드되어 있는 파일을 삭제한 후 재시도하여 주십시오");
								continue;
							}
						}
						// 기존에 존재하는 파일인지 확인
						EncodedFile dbFile = this.selectFileInfoByType(encodeFile);
						
						// 같은 게시물번호(dbFile.getBoardNum()로 얻어지는 번호)에 같은 파일은 업로드 불가
						if(dbFile != null && dbFile.getBoardNum() == num) {
							respon.setStatus(false);
							respon.setMessage("같은 이름의 파일은 업로드 할 수 없습니다.("+dbFile.getFileName()+")");
							continue;
						} else {
							// 검증 종료 후 업로드 및 DB 저장
							locateFileOnServer(file, encodeFile);  		
 							ThumbnailUpload(encodeFile);      
							fileDao.insertFileName(encodeFile);   	   
						}
					}
				}	
			}
		}
		return respon;
	}
	
	private void ThumbnailUpload(EncodedFile encFile) {
		String thumbName = encFile.getThumbUrl();
		String encName = encFile.getEncodedFileName();
		try {
			Thumbnails.of(new File(stringUtil.getUploadPath() + encName))
				  		  .size(100, 100)
				  		  .toFile(new File(stringUtil.getThumbnailUploadPath() +thumbName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	private void locateFileOnServer(MultipartFile file, EncodedFile encFile) {
		String encName = encFile.getEncodedFileName();
		File filepath = new File(stringUtil.getUploadPath() + encName);
	
			try {
				file.transferTo(filepath);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteLocatedFileOnServer(String encodedName) {
		File file = new File(stringUtil.getUploadPath() + encodedName);
		if(file.exists()) {
			file.delete();
		}
	}
	
	@Override
	public void deleteFileByFileNum(int num) {
		fileDao.deleteFileByFileNum(num);
	}

	@Override
	@Transactional
	public void deleteFileByBoardNum(String bbsId, int boardNum) {
		List<EncodedFile> deleteList = this.selectFileInfo(bbsId, boardNum);
		for(EncodedFile file : deleteList) {
			this.deleteLocatedFileOnServer(file.getEncodedFileName());
			this.deleteFileByFileNum(file.getNum());
		}
				
	}

	@Override
	public EncodedFile selectFileInfoByFileNum(int filenum) {
		return fileDao.selectFileInfoByFileNum(filenum);
	}

	@Override
	public void locateFileOnServer(MultipartFile file, String uploadPath, String fileName) {
		File filePath = new File(uploadPath, fileName);
	    try {
	      file.transferTo(filePath);
	    } catch (IllegalStateException e) {
	      e.printStackTrace();
	      throw new RuntimeException(e);
	    } catch (IOException e) {
	      e.printStackTrace();
	      throw new RuntimeException(e);
	    }	
	}

			
}
