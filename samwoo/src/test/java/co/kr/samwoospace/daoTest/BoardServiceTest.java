package co.kr.samwoospace.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.samwoospace.bean.Param;
import co.kr.samwoospace.bean.TechRecord;
import co.kr.samwoospace.dao.boardDAO;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.util.Paging;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/servlet-context.xml", "/mybatis-context.xml"})
public class BoardServiceTest {

	@Resource(name="boardService")
	private BoardService boardService;

	@Test
	public void daoTest() {
		Param<String,Object> param = new Param<String,Object>();
		param.put("num", 1);
		
		Paging paging = boardService.selectPagingInfoByCondition("result", "/project", 1, 9, param);
		
		System.out.println("°¨¸® total " + paging.getTotalCount());
		System.out.println(paging.makePageGroup());
		
	}
	
	@Test
	public void test() {
		
		
	}
	
}
