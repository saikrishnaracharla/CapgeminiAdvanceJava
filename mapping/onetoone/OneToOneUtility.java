package com.Mappings;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneUtility {
	private static final SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	public static SessionFactory getSf() {
		return sf;
	}

}
