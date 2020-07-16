package com.akilamaxi.circuitBreaker.controller;

import com.akilamaxi.circuitBreaker.service.BusinessService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/backendA")
public class BackendAController {
    private static final String MAIN_SERVICE = "mainService";

    private final BusinessService businessAService;

    public BackendAController(@Qualifier("businessAService") BusinessService businessAService){
        this.businessAService = businessAService;
    }

    @GetMapping("/hello")
    @CircuitBreaker(name = MAIN_SERVICE, fallbackMethod="testFallBack")
    public String failure(){
        return businessAService.hello();
    }

    String testFallBack(Exception ex){
        return "Hey I'm Fallback method";
    }

}
