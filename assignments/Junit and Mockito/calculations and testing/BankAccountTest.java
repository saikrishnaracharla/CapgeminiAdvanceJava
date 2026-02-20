package com.practice;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BankAccountTest {
	@Test
	public void testDeposit() {
	BankAccount ba=new BankAccount();
	ba.deposit(1000);
	assertEquals(1000,ba.getBalance());
	}
	@Test
	public void testWithdraw(){
		BankAccount ba=new BankAccount();
		ba.deposit(1000);
		ba.withdraw(200);
		assertEquals(800, ba.getBalance());
	}
	@Test
	public void negativeDeposit() {
		BankAccount ba=new BankAccount();
		assertThrows(IllegalArgumentException.class,()->{
			ba.deposit(-1000);
		});
	}
	@Test
	public void testInsufficientbal() {
		BankAccount ba=new BankAccount();
		assertThrows(IllegalArgumentException.class, ()->{
			ba.deposit(1000);
			ba.withdraw(12000);
		});
	}
}
