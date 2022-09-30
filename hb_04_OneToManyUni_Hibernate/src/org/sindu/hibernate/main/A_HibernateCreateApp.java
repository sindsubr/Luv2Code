package org.sindu.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entity.Course;
import org.sindu.hibernate.entity.Instructor;
import org.sindu.hibernate.entity.InstructorDetail;
import org.sindu.hibernate.entity.Review;
import org.sindu.hibernate.utils.HibernateUtils;

public class A_HibernateCreateApp {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Instructor instructor = new Instructor("Chad", "Darby", "chaddarby@luv2code.com");
			Instructor instructor1 = new Instructor("28Min", "Jhon", "jhon@28min.com");
			InstructorDetail instructorDetail = new InstructorDetail("chadDarbyChannel", "Tutorial");
			InstructorDetail instructorDetail1 = new InstructorDetail("28MinChannel", "Tutorial");
			instructor.setInstructorDetail(instructorDetail);
			instructor1.setInstructorDetail(instructorDetail1);
			session.save(instructor);
			session.save(instructor1);
//			Instructor instructor = session.get(Instructor.class, 1);
//			InstructorDetail instructorDetail = new InstructorDetail("chadDarbyChannel", "Tutorial");
//			instructor.setInstructorDetail(instructorDetail);
			
			Course course = new Course("Spring Framework");
			Course course1 = new Course("Core JAVA");
			Course course2 = new Course("Core JAVA");
			
			instructor.addCourse(course);
			instructor.addCourse(course1);
			
			instructor1.addCourse(course2);
			
			course.setInstructor(instructor);
			course1.setInstructor(instructor);
			course2.setInstructor(instructor1);
			
			
			
			Review review = new Review("Great course..I loved it");
			Review review1 = new Review("Worst course :(");
			Review review2 = new Review("Appreciated for the work...!");
			Review review3 = new Review("amazing effort");
			Review review4 = new Review("great effort");
			
			course.addReviews(review);
			course.addReviews(review1);
			course.addReviews(review2);
			
			course1.addReviews(review3);
			course1.addReviews(review4);
			
			session.save(course);
			session.save(course1);
			session.save(course2);
			
			session.save(review);
			session.save(review1);
			session.save(review2);
			session.save(review3);
			session.save(review4);
			
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
