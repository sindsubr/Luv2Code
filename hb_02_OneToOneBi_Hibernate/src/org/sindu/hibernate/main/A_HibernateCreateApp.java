package org.sindu.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entity.Instructor;
import org.sindu.hibernate.entity.InstructorDetail;
import org.sindu.hibernate.utils.HibernateUtils;

public class A_HibernateCreateApp {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Instructor instructor = new Instructor("Chad", "Darby", "chaddarby@luv2code.com");
			Instructor instructor1 = new Instructor("28Min", "Jhon", "jhon@28min.com");
			Instructor instructor2 = new Instructor("Koushik", "Dev", "koushik@jetbrains.com");
			InstructorDetail instructorDetail = new InstructorDetail("chadDarbyChannel", "Tutorial");
			InstructorDetail instructorDetail1 = new InstructorDetail("28MinChannel", "Tutorial");
			InstructorDetail instructorDetail2 = new InstructorDetail("jetbrainsChannel", "Tutorial");
			instructor.setInstructorDetail(instructorDetail);
			instructor1.setInstructorDetail(instructorDetail1);
			instructor2.setInstructorDetail(instructorDetail2);
			session.save(instructor);
			session.save(instructor1);
			session.save(instructor2);
//			Instructor instructor = session.get(Instructor.class, 1);
//			InstructorDetail instructorDetail = new InstructorDetail("chadDarbyChannel", "Tutorial");
//			instructor.setInstructorDetail(instructorDetail);
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
