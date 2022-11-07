package com.teksystems.schooldatabase.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class DAO {
	protected SessionFactory factory;
	protected Session session;
	protected Transaction t;
	
	protected void init() {
		factory = new Configuration().configure().buildSessionFactory();
		session = factory.openSession();
		t = session.beginTransaction();
	}
	
	protected void close() {
		t.commit();
		factory.close();
		session.close();
	}
}
