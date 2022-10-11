package org.springmvcweb.hibernate.customerorder.service;

import org.springmvcweb.hibernate.customerorder.entity.Customer;
import org.springmvcweb.hibernate.customerorder.entity.CustomerOrder;

public interface CustomerOrderService {
	public void saveCustomerOrder(Customer customer, CustomerOrder order);

}
