package org.springmvcweb.hibernate.customerorder.dao;

import org.springmvcweb.hibernate.customerorder.entity.Customer;
import org.springmvcweb.hibernate.customerorder.entity.CustomerOrder;

public interface CustomerOrderDao {

	void saveCustomerOrder(Customer customer,CustomerOrder order);

}
