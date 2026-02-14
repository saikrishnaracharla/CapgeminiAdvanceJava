package com.Mappings;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToOne {
	public static void main(String[] args) {
		Session s=OneToOneUtility.getSf().openSession();
		Transaction t=s.beginTransaction();
		
		Aadhar a=new Aadhar();
		a.setAnumber("123213AAsaIWJS");
		
		//s.saveOrUpdate(a);

		Person p=new Person();
		p.setName("krishna");
		p.setDob("05-03-2003");
		p.setAddress("111/rk towers/mncl/504208");
		s.saveOrUpdate(p);
		
		t.commit();
 
		s.close();
		
		System.out.println("correct");
	}
	
	

}
