package com.greatlearning.crm1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.crm1.model.Customer;


@Repository
@Transactional
@EnableTransactionManagement
public class CustomerDAOImpl implements CustomerDAO{
	
	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public java.util.List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		//Currentsession
		Session currentSession= sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> theQuery= currentSession.createQuery("from Customer",Customer.class);
		
		//get resultlist
		List<Customer> customers= theQuery.getResultList();
		return customers;
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		Session currentSession= sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, customerId);
		return customer;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		Session currentSession= sessionFactory.getCurrentSession();
		
		//save or update customer
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		
		Session currentSession= sessionFactory.getCurrentSession();
		
		//delete object with Primary key
		Query delQuery=
				currentSession.createQuery("delete from Customer where id=:customerId");
		delQuery.setParameter("customerId", customerId);
		
		delQuery.executeUpdate();
		
	}
}