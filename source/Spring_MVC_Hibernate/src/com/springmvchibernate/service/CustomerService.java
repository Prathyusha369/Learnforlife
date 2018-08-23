package com.springmvchibernate.service;

import java.util.List;

import com.springmvchibernate.entity.Customer;

public interface CustomerService {

	
	public List<Customer> getList();

	public void saveCustomer(Customer customer);

	public void putCustomer(Customer customer);

	public void deleteCustomer(int customerid);

	public Customer getCustomer(int id);
	
	
	
}
