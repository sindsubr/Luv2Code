package org.sindu.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entity.Course;
import org.sindu.hibernate.utils.HibernateUtils;

public class B_HibernateReadApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			int id = 1;
			
			Course course = session.get(Course.class, id);
			System.out.println("Course fetched:" + course);
			System.out.println("Students for the fetched course:" + course.getStudents());
//			Student student = session.get(Student.class, id);
//			System.out.println("Student fetched:" + student);
//			System.out.println("Courses for the fetched student:" + student.getCourses());
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
