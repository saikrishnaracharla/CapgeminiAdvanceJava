package com.Calculator;

public class AgeValidater {
//	public boolean validator(int age) {
//		if(age<0) {
//			throw new IllegalArgumentException("invalid age");
//		}
//		return age>=18 || age<60;
//		
//	}
	private Database db1;
	public AgeValidater(Database db) {
		this.db1=db;
	}
	
	public void validateAge(int age) {
		if(age<=0)
		throw new IllegalArgumentException("invalid age");
	
	db1.saveAge(age);
	}
}
