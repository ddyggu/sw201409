package co.kr.samwoospace.utilTest;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.samwoospace.bean.Param;
import co.kr.samwoospace.service.*;
import co.kr.samwoospace.util.Paging;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/servlet-context.xml", "/mybatis-context.xml"})
public class pagingTest {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@Test
	public void currentGroupTest() {
		int startPage = 5;
		int pageCount = 10;
		int currentGroup = startPage % pageCount > 0 ? startPage / pageCount + 1 : startPage / pageCount;

		System.out.println(startPage % pageCount);
		System.out.println(currentGroup);
	}

	@Test
	public void PagingTest() {
		Paging paging = boardService.selectPagingInfo("technology", "admin/technology", 1);
		
		Param<String,Object> param = new Param<String,Object>();
		param.put("division", "°¨¸®");
		
		paging.setTotalCount(110);
		paging.setParam(param);
		
		System.out.println(paging.makePageGroup());
		
		
	}
}
