package com.greatlearning.crm1.dao;

import java.util.List;

import com.greatlearning.crm1.model.Customer;

public interface CustomerDAO {
	
	public List<Customer> getAllCustomers();
	public Customer getCustomer(int customerId);
	public void save(Customer customer);
	public void deleteCustomer(int customerId);

}
