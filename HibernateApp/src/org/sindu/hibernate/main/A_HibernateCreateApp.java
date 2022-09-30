package org.sindu.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.sindu.hibernate.entiry.Student;
import org.sindu.hibernate.utils.DateUtils;
import org.sindu.hibernate.utils.HibernateUtils;

public class A_HibernateCreateApp {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		List<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student("Sinduja", "Sabarish", "sindujasabarish@gmail.com", DateUtils.parse("28/03/1995"), null));
		studentList.add(new Student("Sabarish", "Ramesh", "sabarishramesh@yahoo.com", DateUtils.parse("29/11/1989"), null));
		studentList.add(new Student("Sai Balaji", "Subramanian", "sai@gmail.com", DateUtils.parse("17/09/1996"), null));
		studentList.add(new Student("Sai Adhvik", "Sabarish", "sai@yahoo.com", DateUtils.parse("28/03/2020"), null));
		studentList.add(new Student("Jhon", "Doe", "jhondoe@any.com", DateUtils.parse("28/06/1993"), null));
		studentList.add(new Student("Malli", "Doe", "mallidoe@any.com", DateUtils.parse("27/03/1992"), null));
		
		try {
			session.beginTransaction();
			studentList.stream().forEach(student->{
				session.save(student);
//				System.out.println("The data " + student + "submitted successfully");
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
