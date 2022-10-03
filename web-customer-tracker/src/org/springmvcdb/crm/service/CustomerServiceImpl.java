package org.springmvcdb.crm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springmvcdb.crm.dao.CustomerDAO;
import org.springmvcdb.crm.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	@Transactional
	@Override
	public void insertData() {
		customerDAO.insertData();
	}

	@Transactional
	@Override
	public List<Customer> listCustomers() {
		return customerDAO.listCustomers();
	}

	@Transactional
	@Override
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	@Transactional
	@Override
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Transactional
	@Override
	public void deleteCustomer(int id) {
		 customerDAO.deleteCustomer(id);
	}

}
