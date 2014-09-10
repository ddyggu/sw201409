package co.kr.samwoospace;

import static org.junit.Assert.*;

import org.junit.Test;

public class findTest {

	@Test
	public void test() {
		String record = "technology&105";
		int border = record.indexOf("&");
		
		String bbsId = record.substring(0, border);
		int boardNum = Integer.parseInt(record.substring(border+1, record.length()));
	
		System.out.println(bbsId);
		System.out.println(boardNum);
	}

}
