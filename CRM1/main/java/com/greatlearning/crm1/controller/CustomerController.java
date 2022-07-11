package com.greatlearning.crm1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.crm1.model.Customer;
import com.greatlearning.crm1.service.CustomerService;

@Controller
@RequestMapping("/customer")	// http(s)://<host>/<projectname>/customer
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")// http(s)://<host>/<projectname>/customer/list
	public String showCustomers(Model model) {
		List<Customer> customers = customerService.getAllCustomers();
		model.addAttribute("customers", customers);
		return "customer-list";	//	/WEB-INF/views/customer-list.jsp
	}
	@RequestMapping("/addNewCustomer")
	public String addNewCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customerObj", customer);
		return "customer-form";
	}
	@RequestMapping("/updateCustomer")	// /CRM/updateCustomer/updateBook?id=2
	public String updateCustomer(@RequestParam(name = "id") int customerId, Model model) {
		Customer customer = customerService.getCustomer(customerId);
		model.addAttribute("customerObj", customer);
		return "customer-form";
	}
	@PostMapping("/save")
	public String saveCustomer(@RequestParam(name = "id") int customerId, 
			@RequestParam(value = "firstname") String firstname,
			@RequestParam(value = "lastname") String lastname,
			@RequestParam(value = "email") String email
			) {
		Customer customer = null;
		if (customerId == 0) {
			customer = new Customer(firstname, lastname, email);
		} else {
			customer = customerService.getCustomer(customerId);
			customer.setFirstname(firstname);
			customer.setLastname(lastname);
			customer.setEmail(email);
		}
		customerService.save(customer);
		return "redirect:list";
	}
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam(name="id")int customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:list";	// CRM/customer/list
	}
	
}
