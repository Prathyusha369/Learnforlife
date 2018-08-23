package com.springmvchibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvchibernate.entity.Customer;

@Repository("CustomerDao")

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub

		return sessionFactory.getCurrentSession().createQuery("from Customer order by lastName", Customer.class)
				.getResultList();

	}

	@Override
	public void addCustomers(Customer customer) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public void putCustomers(Customer customer) {
		// TODO Auto-generated method stub

		/*
		 * Customer customer2 = sessionFactory.getCurrentSession()
		 * .createQuery("from Customer where id = : id ",
		 * Customer.class).setParameter("id", customer.getId()) .getSingleResult();
		 */

		sessionFactory.getCurrentSession().saveOrUpdate(customer);;

	}

	@Override
	public void deleteCustomer(int customerid) {
		Session session =sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, customerid);

		session.delete(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Customer.class, id);
	}

}
