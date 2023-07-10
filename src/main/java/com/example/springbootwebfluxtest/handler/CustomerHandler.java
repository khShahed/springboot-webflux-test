package com.example.springbootwebfluxtest.handler;

import com.example.springbootwebfluxtest.dao.CustomerDao;
import com.example.springbootwebfluxtest.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> loadCustomers(ServerRequest request) {
        Flux<Customer> customersList = customerDao.getCustomersList();
        return ServerResponse.ok().body(customersList, Customer.class);
    }
}
