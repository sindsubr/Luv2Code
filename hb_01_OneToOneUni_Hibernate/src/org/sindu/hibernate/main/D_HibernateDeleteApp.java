package org.sindu.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entity.Instructor;
import org.sindu.hibernate.utils.HibernateUtils;

public class D_HibernateDeleteApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			int id = 4;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("Instructor for id " + id + ":\t" + instructor);
			session.delete(instructor);
			System.out.println("Deleted the row in both instructor and its associated tables");
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
