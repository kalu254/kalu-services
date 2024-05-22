package com.kalu.fraud.controller;


import com.kalu.fraud.service.FraudCheckService;
import com.kalu.fraud.model.response.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {


    private final FraudCheckService fraudCheckService;




    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("is customer fraudulent " + isFraudulentCustomer);
        return new FraudCheckResponse(isFraudulentCustomer, LocalDateTime.now());
    }
}
