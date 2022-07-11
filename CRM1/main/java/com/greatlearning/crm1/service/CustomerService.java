package com.greatlearning.crm1.service;

import java.util.List;

import com.greatlearning.crm1.model.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer getCustomer(int customerId);
	public void save(Customer customer);
	public void deleteCustomer(int customerId);
}
