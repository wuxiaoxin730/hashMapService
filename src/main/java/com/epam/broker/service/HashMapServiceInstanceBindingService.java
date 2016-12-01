package com.epam.broker.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.model.DeleteServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class HashMapServiceInstanceBindingService implements ServiceInstanceBindingService {
    private Logger logger = Logger.getLogger(HashMapServiceInstanceBindingService.class);

    @Autowired
    private CustomHashMapService customHashMapService;

    @Override
    public CreateServiceInstanceBindingResponse createServiceInstanceBinding(CreateServiceInstanceBindingRequest createServiceInstanceBindingRequest) {
        logger.debug("Method enter into method createServiceInstanceBinding()...");
        Map<String, Object> credentials = Collections.singletonMap("hashMap", customHashMapService);
        return null;
    }

    @Override
    public void deleteServiceInstanceBinding(DeleteServiceInstanceBindingRequest deleteServiceInstanceBindingRequest) {
        logger.debug("Method enter into method deleteServiceInstanceBinding()...");
    }
}
