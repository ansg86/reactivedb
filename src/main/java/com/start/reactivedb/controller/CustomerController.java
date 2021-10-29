package com.start.reactivedb.controller;

import com.start.reactivedb.model.Customer;
import com.start.reactivedb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Mono<Customer> createCustomer(@RequestBody Customer customer) {
        return customerService.addNewCustomer(customer);
    }

    @GetMapping("/{id}")
    public Mono<Customer> getCustomer(@PathVariable(value = "id") Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/last-name/{lastName}")
    private Flux<Customer> getCustomerByLastName(@PathVariable(value = "lastName") String lastName) {
        return customerService.getCustomerByLastName(lastName);
    }

    @GetMapping("/all")
    public Flux<Customer> getAll() {
        return customerService.findAllCustomer();
    }
}
