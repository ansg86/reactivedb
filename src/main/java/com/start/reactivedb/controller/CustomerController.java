package com.start.reactivedb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.start.reactivedb.model.Customer;
import com.start.reactivedb.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/create")
	public void createCustomer() {
		Customer customer = Customer.builder().firstName("test").lastName("test-last").build();
		customerService.addNewCustomer(customer);
	}
	
	@GetMapping("/all")
	public List<Customer> getAll() {
		return customerService.findAllCustomer();
	}
}
