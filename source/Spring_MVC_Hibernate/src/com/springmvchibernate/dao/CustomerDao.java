package com.springmvchibernate.dao;

import java.util.List;

import com.springmvchibernate.entity.Customer;

public interface CustomerDao {

	
	public List<Customer> getCustomers();

	public void addCustomers(Customer customer);

	public void putCustomers(Customer customer);

	public void deleteCustomer(int customerid);

	public Customer getCustomer(int id);
	
}
