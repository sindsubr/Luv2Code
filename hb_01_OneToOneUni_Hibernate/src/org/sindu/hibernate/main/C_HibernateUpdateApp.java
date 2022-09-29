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
			System.out.println("Instructor for id " + id + ":\t" + instructor);
			InstructorDetail instructorDetail = null;
			if (instructor != null) {
				instructorDetail = instructor.getInstructorDetail();
				instructorDetail.setHobby("Table Tennis");
			}
			session.update(instructorDetail);
			System.out.println("InstructorDetail for id " + id + ":\t" + instructorDetail);
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
