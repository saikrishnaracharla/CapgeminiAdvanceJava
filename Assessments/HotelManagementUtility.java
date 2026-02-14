package com.lpu.HotelManagement;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HotelManagementUtility {
	private static final SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	public static SessionFactory getSf() {
		return sf;
	}
	
}
