package org.sindu.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.sindu.hibernate.entity.Course;
import org.sindu.hibernate.utils.HibernateUtils;

public class E_HibernateReadJOINFETCHHQLApp {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			int id = 2;
			// For Lazy fetch, You can use HQL query for fetching all atonce
			Query<Course> query = session.createQuery("select i from Course i "
					+ "INNER JOIN FETCH i.students "
					+ "where i.id = :studentId",Course.class);
			query.setParameter("studentId", id);
			Course course = query.getSingleResult();
			System.out.println("Course for id "+ id +":\t" + course);
			session.getTransaction().commit();
			
			//Lazy Fetch
			System.out.println(course.getStudents());
			
		} catch (Exception e) {
			session.close();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
