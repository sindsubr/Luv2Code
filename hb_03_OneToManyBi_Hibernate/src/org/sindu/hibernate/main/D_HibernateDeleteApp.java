package org.sindu.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entity.Course;
import org.sindu.hibernate.entity.Instructor;
import org.sindu.hibernate.utils.HibernateUtils;

public class D_HibernateDeleteApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			int id = 2;
			
			Course course = session.get(Course.class, id);
			session.delete(course);
			System.out.println(session.get(Instructor.class, id));
			id = 4;
			Instructor instructor = session.get(Instructor.class, id);
			List<Course> courseList = instructor.getCourses();
			courseList.stream().forEach(courseObj->{
				courseObj.setInstructor(null);
			});
			session.delete(instructor);
			
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
