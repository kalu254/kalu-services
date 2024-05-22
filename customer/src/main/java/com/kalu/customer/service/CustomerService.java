package com.kalu.customer.service;

import com.kalu.customer.CustomerRepository;
import com.kalu.customer.model.Customer;
import com.kalu.customer.model.request.CustomerRegistrationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //TODO : validate data


        customerRepository.save(customer);

    }
}
