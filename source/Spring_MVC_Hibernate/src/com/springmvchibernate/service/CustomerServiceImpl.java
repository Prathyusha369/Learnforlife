package com.springmvchibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvchibernate.dao.CustomerDao;
import com.springmvchibernate.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Override
	@Transactional
	public List<Customer> getList() {
	
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.addCustomers(customer);
	}

	@Override
	@Transactional
	public void putCustomer(Customer customer) {
	customerDao.putCustomers(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerid) {
		// TODO Auto-generated method stub
		customerDao.deleteCustomer(customerid);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		
		return customerDao.getCustomer(id);
		 
	}

}
