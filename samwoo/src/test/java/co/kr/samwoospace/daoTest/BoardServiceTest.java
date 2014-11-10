package co.kr.samwoospace.daoTest;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.samwoospace.bean.ClubInfoRecord;
import co.kr.samwoospace.bean.ClubRecord;
import co.kr.samwoospace.bean.Param;
import co.kr.samwoospace.bean.PopupRecord;
import co.kr.samwoospace.bean.TechRecord;
import co.kr.samwoospace.dao.boardDAO;
import co.kr.samwoospace.service.BoardService;
import co.kr.samwoospace.util.Paging;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/servlet-context.xml", "/mybatis-context.xml"})
public class BoardServiceTest {

	@Resource(name="boardService")
	private BoardService boardService;
	private MockMultipartHttpServletRequest request;
	
	@Test
	public void test() {
		Param<String,Object> param = new Param<String,Object>();
		param.put("num", 3);
		Paging paging = boardService.selectPagingInfoByCondition("club", "/community05_list", 1, 9, param);
		List<ClubRecord> clubList = boardService.ListClubRecord(paging);

		for(ClubRecord club : clubList) {
			System.out.println(club.getTitle());
		}
	}
	
}
