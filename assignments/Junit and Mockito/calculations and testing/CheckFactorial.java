package com.Calculator;

public class CheckFactorial {
	public int fact(int input) {
		if(input<0)
			throw new IllegalArgumentException("not valid");
		
	 int fact=1;
	for(int i=1;i<=input;i++) {
		fact=fact*i;
	}
	return fact;

}

}
