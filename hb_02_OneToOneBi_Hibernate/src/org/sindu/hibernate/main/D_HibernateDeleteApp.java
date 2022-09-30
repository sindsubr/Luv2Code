package org.sindu.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entity.InstructorDetail;
import org.sindu.hibernate.utils.HibernateUtils;

public class D_HibernateDeleteApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			int id = 1;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			System.out.println("InstructorDetail for id " + id + ":\t" + instructorDetail);
			session.delete(instructorDetail);
			System.out.println("Deleted the row in both instructorDetail also its associated tables because of bi-directional");
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
