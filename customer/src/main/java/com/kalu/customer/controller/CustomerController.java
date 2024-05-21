package com.kalu.customer.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController() {


    public void registerCustomer(@RequestBody  CustomerRequest customerRequest ){
        log.info("new customer registration {}", customerRequest);
    }
}
