package com.example.springbootwebfluxtest.controller;

import com.example.springbootwebfluxtest.dto.Customer;
import com.example.springbootwebfluxtest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/stream")
    public Flux<Customer> getCustomersStream() {
        return customerService.getAllCustomersStream();
    }
}
