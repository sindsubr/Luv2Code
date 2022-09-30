package org.sindu.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entity.Student;
import org.sindu.hibernate.utils.HibernateUtils;

public class D_HibernateDeleteApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			int id = 1;
//			Course course = session.get(Course.class, id);
//			session.delete(course);
			Student student = session.get(Student.class, id);
			session.delete(student);
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
