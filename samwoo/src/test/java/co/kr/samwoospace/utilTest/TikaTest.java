package co.kr.samwoospace.utilTest;

import static org.junit.Assert.*;

import org.junit.Test;

import co.kr.samwoospace.bean.Category;

public class TikaTest {

	@Test
	public void test() {
		String name = Category.valueOf("MEWE").getName();
		System.out.println(name);
	}

}
