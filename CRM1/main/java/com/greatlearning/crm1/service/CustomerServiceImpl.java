package com.greatlearning.crm1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.crm1.dao.CustomerDAO;
import com.greatlearning.crm1.model.Customer;

@Service
@EnableTransactionManagement
public class CustomerServiceImpl implements CustomerService {
	
	//Inject DAO
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {

		return customerDAO.getAllCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(customerId);
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.save(customer);

	}

	@Transactional
	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(customerId);
	}

}
