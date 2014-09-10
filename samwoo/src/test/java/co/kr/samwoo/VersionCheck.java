package co.kr.samwoo;

import static org.junit.Assert.*;

import org.junit.Test;

public class VersionCheck {

	@Test
	public void test() {
		System.out.println(org.springframework.core.SpringVersion.getVersion());
	}

}
