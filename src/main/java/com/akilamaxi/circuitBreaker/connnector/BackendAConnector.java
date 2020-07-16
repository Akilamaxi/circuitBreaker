package com.akilamaxi.circuitBreaker.connnector;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * This Connector shows how to use the CircuitBreaker annotation.
 */

@Component(value = "backendAConnector")
public class BackendAConnector implements Connector {



    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String callOtherService() {
       return restTemplate.getForObject("http://localhost:8081/serviceOne", String.class);

    }

}
