package org.springmvcdb.crm.service;

import java.util.List;

import org.springmvcdb.crm.entity.Customer;

public interface CustomerService {
	public void insertData();
	public List<Customer> listCustomers();
	public void addCustomer(Customer customer);
	public Customer getCustomer(int id);
	public void deleteCustomer(int id);
}
