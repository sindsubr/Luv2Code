package org.sindu.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.sindu.hibernate.entity.Course;
import org.sindu.hibernate.entity.Instructor;
import org.sindu.hibernate.entity.InstructorDetail;
import org.sindu.hibernate.utils.HibernateUtils;

public class E_HibernateReadJOINFETCHHQLApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			int id = 1;
			// For Lazy fetch, You can use HQL query for fetching all atonce
			Query<Course> query = session.createQuery("select i from Course i "
					+ "INNER JOIN FETCH i.reviews "
					+ "where i.id = :courseId",Course.class);
			query.setParameter("courseId", id);
			Course course = query.getSingleResult();
			System.out.println("Instructor for id "+ id +":\t" + course);
			session.getTransaction().commit();
			
			//Lazy Fetch
			System.out.println(course.getReviews());
			
		} catch (Exception e) {
			session.close();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
