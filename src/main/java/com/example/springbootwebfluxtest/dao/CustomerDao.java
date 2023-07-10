package com.example.springbootwebfluxtest.dao;

import com.example.springbootwebfluxtest.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepExecution(int i) {
        try {
            Thread.sleep(i * 10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getCustomers() {
        return IntStream.rangeClosed(1, 50)
                .peek(CustomerDao::sleepExecution)
                .peek(System.out::println)
                .mapToObj(i -> new Customer(i, "cutomer " + i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream() {
        return Flux.range(1, 50)
                .delayElements(Duration.ofMillis(100))
                .doOnNext(System.out::println)
                .map(i -> new Customer(i, "cutomer " + i));
    }

    public Flux<Customer> getCustomersList() {
        return Flux.range(1, 50)
                .doOnNext(System.out::println)
                .map(i -> new Customer(i, "cutomer " + i));
    }
}
