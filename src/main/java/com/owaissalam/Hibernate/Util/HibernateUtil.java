package com.owaissalam.Hibernate.Util;

import org.hibernate.cfg.Configuration;

import com.owaissalam.Hibernate.entities.Student;

import org.hibernate.SessionFactory;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	static {
		try {
			if(sessionFactory == null) {
				sessionFactory = new Configuration()
						.configure("hibernate.cfg.xml")				
						.buildSessionFactory();
			}
		}
		catch (Exception e) {
			 throw new RuntimeException("Error in creating session factory" + e.getMessage());
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
