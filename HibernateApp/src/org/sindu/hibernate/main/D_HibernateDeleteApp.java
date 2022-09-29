package org.sindu.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entiry.Student;
import org.sindu.hibernate.utils.HibernateUtils;

public class D_HibernateDeleteApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Student student1 = session.get(Student.class, 2);
//			session.delete(student1);
			session.createQuery("delete from Student").executeUpdate();
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
