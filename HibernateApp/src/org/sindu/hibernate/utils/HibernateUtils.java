package org.sindu.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sindu.hibernate.entiry.Student;

public class HibernateUtils {

	private static SessionFactory factory = null;

	public static SessionFactory getSessionFactory() {
		try {
			if (factory == null) {
				build();
			}
		} catch (Exception e) {
			System.out.println("Exception occurs while creating session factory");
		}

		System.out.println("factorty hashcode " + factory.hashCode());
		Session session = null;
		try {
			session = factory.getCurrentSession();
			System.out.println("session hashcode" + session);
		} catch (Exception e) {
			System.out.println("Exception occurs while creating session");
			e.printStackTrace();
		}
		return factory;
	}

	private static void build() {
		factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	}
}
