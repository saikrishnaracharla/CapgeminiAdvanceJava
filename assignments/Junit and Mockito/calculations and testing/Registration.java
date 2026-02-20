package com.practice;

public class Registration {
	public boolean userInfo(String name,String password) {
		if(name==null && name.trim().isEmpty()) {
			throw new IllegalArgumentException("name cannot be empty");
		}
		if(password.length()<8) {
			throw new IllegalArgumentException("pass length must be greater than 8");
		}
		return true;
	}

}
