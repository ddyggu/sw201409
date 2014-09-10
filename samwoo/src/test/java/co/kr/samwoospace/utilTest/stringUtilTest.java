package co.kr.samwoospace.utilTest;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.samwoospace.util.StringUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/servlet-context.xml", "/mybatis-context.xml"})
public class stringUtilTest {

	@Resource(name="stringUtility")
	private StringUtility stringUtil;
	
	@Test
	public void test() {
		System.out.println(stringUtil.getRelativePath());
	}

}
