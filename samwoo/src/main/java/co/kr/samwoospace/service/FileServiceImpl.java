package co.kr.samwoospace.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.tika.Tika;
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
					
					System.out.println(contentType);
					
					if(originalName.equals("") == false) {
						encodedName = stringUtil.encodedFileName(originalName);
						/* Ȯ���� �˻�
						if(stringUtil.isIllegalExtension(originalName)) {
							respon.setStatus(false);
							respon.setMessage("���ε��� �� ���� �����Դϴ�.("+originalName+")");
							continue;
						}
						*/
						
						if(stringUtil.isIllegalMimeType(contentType)) {
							respon.setStatus(false);
							respon.setMessage("���ε��� �� ���� ������ �����Դϴ�.("+originalName+")");
							continue;
						}
						
						EncodedFile encodeFile = new EncodedFile();
				
						encodeFile.setBbsId(bbsId);
						encodeFile.setBoardNum(num);
						encodeFile.setFileName(originalName);
						encodeFile.setEncodedFileName(encodedName);			
						encodeFile.setThumbUrl("/thumb_"+encodedName.replaceFirst("/", ""));
						
						// ���� ���� ���ε� ��� ����
						if(moreThanOne == false) {
							List<EncodedFile> fileList = this.selectFileInfo(bbsId, num);
							if(fileList.size() >= 1) {
								respon.setStatus(false);
								respon.setMessage("�� �� �̻��� ������ ���ε� �� �� �����ϴ�. \\n �̹� ���ε�Ǿ� �ִ� ������ ������ �� ��õ��Ͽ� �ֽʽÿ�");
								continue;
							}
						}
						
						// ������ �����ϴ� �������� Ȯ��
						EncodedFile dbFile = this.selectFileInfoByType(encodeFile);
						
						// ���� �Խù���ȣ(dbFile.getBoardNum()�� ������� ��ȣ)�� ���� ������ ���ε� �Ұ�
						if(dbFile != null && dbFile.getBoardNum() == num) {
							respon.setStatus(false);
							respon.setMessage("���� �̸��� ������ ���ε� �� �� �����ϴ�. ("+dbFile.getFileName()+")");
							continue;
						} else {
							// ���� ���� ��� �� ���ε� ����
							locateFileOnServer(file, encodeFile);  		// ���� ���� ���ε�
 							ThumbnailUpload(encodeFile);      // ����� ����, ���ε�
							fileDao.insertFileName(encodeFile);   	   // �������� DB ����
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
