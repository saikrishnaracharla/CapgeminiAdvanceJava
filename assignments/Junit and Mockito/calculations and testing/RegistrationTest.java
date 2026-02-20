package com.practice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrationTest {
	
	private Registration r;
	@BeforeEach
	void setobj() {
		 r=new Registration();
	}
	@Test
	public void testInfo() {
		boolean res=r.userInfo("nani kunmar", "surya@12312");
		assertAll(
				()->assertTrue(res),
				()->assertNotNull(res)
				);
	}
	void testName() {
		assertThrows(IllegalArgumentException.class, ()->{
			r.userInfo("","Strongpassword");
		});
	}
	void testPass() {
		assertThrows(IllegalArgumentException.class, ()->{
			r.userInfo("pawan", "tes");
		});
	}

}
