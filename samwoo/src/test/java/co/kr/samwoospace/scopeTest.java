package co.kr.samwoospace;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.kr.samwoospace.bean.CustomerService;

public class scopeTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] {"servlet-context.xml"});
		
		CustomerService custA = (CustomerService)context.getBean("customerService");
		custA.setMessage("Message by custA");
		System.out.println("message : " + custA.getMessage());
		
		//retrieve it again
		CustomerService custB = (CustomerService)context.getBean("customerService");
		System.out.println("message : " + custB.getMessage());
	
		assertThat(custA == custB, is(true));
	}

}
