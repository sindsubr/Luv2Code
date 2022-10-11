package org.springmvcdb.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springmvcdb.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void insertData() {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = new Customer("Albert", "Einstein", "albert22@siphy.com");
		Customer customer1 = new Customer("Jhon", "Doe", "jhondoe@rivvee.com");
		Customer customer2 = new Customer("Mary", "Jhon", "maryjhon@rivvee.com");
		Customer customer3 = new Customer("Britto", "San", "brito@fricky.com");
		Customer customer4 = new Customer("Vannila", "Shavo", "vanni@bricks.com");
		session.save(customer);
		session.save(customer1);
		session.save(customer2);
		session.save(customer3);
		session.save(customer4);
		System.out.println("Data Inserted successfully");
	}

	@Override
	public List<Customer> listCustomers() {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);
//		session.createQuery("delete from Customer where id = :customerId").setParameter("customerId", id)
//				.executeUpdate();
	}

}
