package org.sindu.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entity.Instructor;
import org.sindu.hibernate.entity.InstructorDetail;
import org.sindu.hibernate.utils.HibernateUtils;

public class B_HibernateReadApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			System.out.println("Instructor for id "+ id +":\t" + instructor);
			InstructorDetail instructorDetail = null;
			if(instructor!=null)
			instructorDetail = instructor.getInstructorDetail();
			System.out.println("InstructorDetail for id "+ id + ":\t" + instructorDetail);
			
			
			id = 2;
			InstructorDetail instructorDetail2 = session.get(InstructorDetail.class, id);
			System.out.println("InstructorDetail for id "+ id + ":\t" + instructorDetail2);
			Instructor instructor2 = instructorDetail2.getInstructor();
			System.out.println("Instructor for id "+ id +":\t" + instructor2);
			
			
			
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
