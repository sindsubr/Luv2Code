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
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "INNER JOIN FETCH i.courses "
					+ "where i.id = :insId",Instructor.class);
			query.setParameter("insId", id);
			Instructor instructor = query.getSingleResult();
			System.out.println("Instructor for id "+ id +":\t" + instructor);
			session.getTransaction().commit();
			
			//Lazy Fetch
			System.out.println(instructor.getCourses());
			
		} catch (Exception e) {
			session.close();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
