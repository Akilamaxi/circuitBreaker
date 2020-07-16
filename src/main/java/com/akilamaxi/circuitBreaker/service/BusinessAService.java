package com.akilamaxi.circuitBreaker.service;

import com.akilamaxi.circuitBreaker.connnector.Connector;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "businessAService")
public class BusinessAService implements BusinessService {

    private final Connector backendAConnector;

    public BusinessAService(@Qualifier("backendAConnector") Connector backendAConnector){
        this.backendAConnector = backendAConnector;
    }

    @Override
    public String hello() {
        return backendAConnector.callOtherService();
    }
}
