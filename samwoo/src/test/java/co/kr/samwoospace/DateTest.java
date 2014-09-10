package co.kr.samwoospace;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class DateTest {
	
	@Test
	public void test() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
		Date endDate = format.parse( "2014-08-31" );
		Date currentDate = new Date();
		
		int result = currentDate.compareTo(endDate);
		
		if(result == 1) {
			System.out.println("모집마감");
		}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
