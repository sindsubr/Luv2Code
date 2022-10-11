package org.springmvcweb.hibernate.customerorder.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springmvcweb.hibernate.customerorder.dao.CustomerOrderDao;
import org.springmvcweb.hibernate.customerorder.entity.Customer;
import org.springmvcweb.hibernate.customerorder.entity.CustomerOrder;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
	@Autowired
	private CustomerOrderDao customerOrderDao;

	@Transactional
	@Override
	public void saveCustomerOrder(Customer customer, CustomerOrder order) {
		customerOrderDao.saveCustomerOrder(customer,order);
	}

}
