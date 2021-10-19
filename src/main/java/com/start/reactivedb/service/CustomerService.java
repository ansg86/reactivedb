package com.start.reactivedb.service;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.start.reactivedb.model.Customer;
import com.start.reactivedb.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public void addNewCustomer(Customer customer) {
		Mono<Customer> customerMono = customerRepository.save(customer);
		Customer storeResult= customerMono.block();
		System.out.println("result " + storeResult.getFirstName());
	}

	public Customer getCustomer(Long id) {
		Mono<Customer> customerMono = customerRepository.findById(id);
		return customerMono.block(Duration.ofSeconds(10));
	}
	
	public List<Customer> findAllCustomer() {
		Flux<Customer> customerFlux= customerRepository.findAll();
		return customerFlux.collectList().block();
	}
}
