package org.sindu.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.sindu.hibernate.entity.Course;
import org.sindu.hibernate.entity.Instructor;
import org.sindu.hibernate.entity.InstructorDetail;
import org.sindu.hibernate.entity.Review;

public class HibernateUtils {

	private static SessionFactory factory = null;

	public static SessionFactory getSessionFactory() {
		try {
			if (factory == null) {
				build();
			}
		} catch (Exception e) {
			System.out.println("Exception occurs while creating session factory");
			e.printStackTrace();
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
		factory = new Configuration().configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
	}
}
