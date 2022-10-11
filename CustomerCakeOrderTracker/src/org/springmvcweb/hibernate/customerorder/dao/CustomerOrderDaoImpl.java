package org.springmvcweb.hibernate.customerorder.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springmvcweb.hibernate.customerorder.entity.Customer;
import org.springmvcweb.hibernate.customerorder.entity.CustomerOrder;

@Repository
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveCustomerOrder(Customer customer,CustomerOrder order) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer where email = :customerEmail", Customer.class);
		query.setParameter("customerEmail", customer.getEmail());
		Customer customerQuery = null;
		try {
			customerQuery = query.getSingleResult();
			customerQuery.setFirstName(customer.getFirstName());
			customerQuery.setLastName(customer.getLastName());
			customerQuery.setMobileNo(customer.getMobileNo());
			customerQuery.setOrders(customer.getOrders());
			customerQuery.addOrders(order);
			
			customer = session.get(Customer.class, customerQuery.getId());
			
			customer.setFirstName(customerQuery.getFirstName());
			customer.setLastName(customerQuery.getLastName());
			customer.setMobileNo(customerQuery.getMobileNo());
			customer.setOrders(customerQuery.getOrders());
			customer.addOrders(order);
			
			session.update(customer);
			
			order.setCustomer(customer);
		} catch (Exception e) {
			session.save(customer);
			customer.addOrders(order);
			order.setCustomer(customer);
		}
		System.out.println("output:" + customer);
		System.out.println("OrderList:"+customer.getOrders());
	}

}
