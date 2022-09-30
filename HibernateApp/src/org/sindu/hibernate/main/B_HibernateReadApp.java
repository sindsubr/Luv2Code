package org.sindu.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entiry.Student;
import org.sindu.hibernate.utils.HibernateUtils;

public class B_HibernateReadApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			//HQL query usage
			List<Student> studentList = session.createQuery("from Student").getResultList();
			 System.out.println(studentList);
			Student ob = session.get(Student.class, 1);
			System.out.println(ob);
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
