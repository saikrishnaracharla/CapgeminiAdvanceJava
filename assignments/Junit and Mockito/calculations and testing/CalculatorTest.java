package com.Calculator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	 @Test
	    void testAdd() {
	        Calculator c = new Calculator();
	        int result = c.add(2, 3);
	        assertTrue(result==5);
	    }
	 @Test
	 void testSub() {
		 Calculator c=new Calculator();
		 int res=c.sub(10,3);
		 assertFalse(res!=7);
	 }
	 @Test
	 void testMul() {
		 Calculator c=new Calculator();
		 int res=c.mul(2,3);
		 assertEquals(6, res);
	 }
	 @Test
	 void testDiv() {
		 Calculator c=new Calculator();
		 int res=c.div(5,1);
		 assertEquals(5, res);
		 
	 }
	 
	 

}
