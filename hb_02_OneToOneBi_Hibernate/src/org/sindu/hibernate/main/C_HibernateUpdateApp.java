package org.sindu.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entity.Instructor;
import org.sindu.hibernate.entity.InstructorDetail;
import org.sindu.hibernate.utils.HibernateUtils;

public class C_HibernateUpdateApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			instructor.setEmail("changed@gmail.com");
			instructorDetail.setHobby("Guitar");
			System.out.println("updated:" + instructor + instructorDetail);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.close();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
