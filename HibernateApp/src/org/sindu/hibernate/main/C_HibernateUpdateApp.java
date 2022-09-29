package org.sindu.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entiry.Student;
import org.sindu.hibernate.utils.HibernateUtils;

public class C_HibernateUpdateApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			List<Student> studentList = session.createQuery("from Student").getResultList();
			 studentList.stream().forEach(student->{
				 if(student.getLastName().equals("Doe")) {
					 student.setLastName("Brave");
					 session.save(student);
				 }
			 });
			 
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
