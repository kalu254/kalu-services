package com.kalu.customer.service;

import com.kalu.customer.repository.CustomerRepository;
import com.kalu.customer.model.Customer;
import com.kalu.customer.model.request.CustomerRegistrationRequest;
import com.kalu.customer.model.response.FraudCheckResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //TODO : validate data
        //TODO : check if fraudster
        customerRepository.saveAndFlush(customer);

        String baseUrl = "http://FRAUD/api/v1/fraud-check/";
        String uri = baseUrl + customer.getId();
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(uri,
                FraudCheckResponse.class,
                customer.getId()
        );
        //TODO: send notification

        assert fraudCheckResponse != null;
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
