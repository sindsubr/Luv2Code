package org.sindu.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entity.Course;
import org.sindu.hibernate.entity.Student;
import org.sindu.hibernate.utils.HibernateUtils;

public class A_HibernateCreateApp {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Student sindu = new Student("Sinduja", "sinduja@gmail.com");
			Student sai = new Student("Sai", "sai@gmail.com");
			Course spring = new Course("Spring Framework");
			Course java = new Course("CORE JAVA");
			Course microservices = new Course("Microservices");
			
			session.save(sindu);
			session.save(sai);
			session.save(spring);
			session.save(java);
			session.save(microservices);
			
			//Students taking courses
			sindu.addCourse(spring);
			sindu.addCourse(java);
			sai.addCourse(microservices);
			sai.addCourse(spring);
			
			
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
