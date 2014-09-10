package co.kr.samwoospace.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.samwoospace.bean.EncodedFile;
import co.kr.samwoospace.service.FileService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/servlet-context.xml", "/mybatis-context.xml"})
public class fileServiceTest {

	@Resource(name="fileService")
	private FileService fileService;
	
	@Test
	public void test() {
		List<EncodedFile> fileList = fileService.selectFileInfo("notice", 8);
		
		for(EncodedFile file : fileList) {
			String newName = file.getEncodedFileName().replaceAll("/", "");
			file.setEncodedFileName(newName);
		}
	}

}
