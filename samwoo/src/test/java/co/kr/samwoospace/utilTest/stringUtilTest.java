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
		String strHTML= "<P><STRONG><SPAN style='FONT-SIZE: 11pt'>전화오늘 하루 300통 틈틈히 햇는데절대안받음.</SPAN><SPAN style='FONT-SIZE: 11pt'>&nbsp;</SPAN></STRONG></P>"+
"<P><SPAN style='FONT-SIZE: 11pt'><STRONG><SPAN style='COLOR: #ff0000'>충전크래들</SPAN></STRONG></SPAN></P>"+
"<P><SPAN style='FONT-SIZE: 11pt'><STRONG><SPAN style='COLOR: #ff0000'>맞교환해주세요!!&nbsp;</SPAN></STRONG></SPAN></P>"+
"<P><STRONG><SPAN style='FONT-SIZE: 11pt'>필요한 시기에 구입햇는데....</SPAN></STRONG></P>"+
"<P><STRONG><SPAN style='FONT-SIZE: 11pt'><SPAN style='COLOR: #ff0000'>지금 </SPAN></SPAN><SPAN style='FONT-SIZE: 11pt'><SPAN style='COLOR: #ff0000'>아이의 안전을 위해 한시가 급한 상황입니다.....</SPAN></SPAN></STRONG></P>"+
"<P><STRONG><SPAN style='FONT-SIZE: 11pt'>서비스센터 전화 아예 안되고.</SPAN></STRONG></P>"+
"<P><SPAN style='FONT-SIZE: 11pt'><STRONG>물건은 상태가 이렇고.</STRONG></SPAN></P>"+
"<P><SPAN style='FONT-SIZE: 11pt'><STRONG>참 실망입니다..</STRONG></SPAN></P>"+
"<P><SPAN style='FONT-SIZE: 11pt'><STRONG>8.25 키즈준신청후</STRONG></SPAN></P>"+
"<P><SPAN style='FONT-SIZE: 11pt'><STRONG>8.28일 목욜 저녁&nbsp;늦게 물건받고</STRONG></SPAN></P>"+
"<P><STRONG><SPAN style='FONT-SIZE: 11pt'>오늘이 8.29일 금요일</SPAN><SPAN style='FONT-SIZE: 11pt'>입니다....서비스센터 </SPAN><SPAN style='FONT-SIZE: 11pt'>통화시도안됨.</SPAN><SPAN style='FONT-SIZE: 11pt'>&nbsp;</SPAN></STRONG></P>"+
"<P><STRONG></STRONG>&nbsp;</P>";

		String ss = stringUtil.removeHTML(strHTML);
		System.out.println(ss);
		
	}

}
