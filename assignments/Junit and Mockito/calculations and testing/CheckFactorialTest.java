package com.Calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CheckFactorialTest {
	@Test
	public void checkfact() {
		CheckFactorial cf=new CheckFactorial();
		int res=cf.fact(5);
		assertEquals(120,res);
	}

}

