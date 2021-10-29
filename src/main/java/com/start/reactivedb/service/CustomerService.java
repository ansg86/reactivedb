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

    public Mono<Customer> addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Mono<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    public Flux<Customer> getCustomerByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    public Flux<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }
}
