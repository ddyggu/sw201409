package co.kr.samwoospace.daoTest;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.samwoospace.bean.Member;
import co.kr.samwoospace.dao.memberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/mybatis-context.xml","/servlet-context.xml"})
public class memberDaoTest {

	@Autowired
	private memberDAO memberdao;
	
	@Test
	public void isAdminMemberTest() {
		Member member = new Member();
		member.setId("supersam");
		member.setPass("woospace!!");
		Member inqueriedMember = memberdao.isAdminMember(member);
		assertThat(member.getId(), is("supersam"));
	}

	@Test
	public void getAdminMember() {
		Member member = memberdao.getAdminMemberInfo();
		assertThat(member.getId(), is("supersam"));
	}	
	
}
