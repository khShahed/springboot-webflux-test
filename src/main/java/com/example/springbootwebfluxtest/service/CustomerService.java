package com.example.springbootwebfluxtest.service;

import com.example.springbootwebfluxtest.dao.CustomerDao;
import com.example.springbootwebfluxtest.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.function.Consumer;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getAllCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomers();
        long end = System.currentTimeMillis();

        System.out.println("Total execution time: " + (end - start));

        return customers;
    }

    public Flux<Customer> getAllCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomersStream();
        long end = System.currentTimeMillis();

        System.out.println("Total execution time: " + (end - start));

        return customers;
    }
}
