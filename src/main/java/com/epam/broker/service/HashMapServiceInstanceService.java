package com.epam.broker.service;

import org.apache.log4j.Logger;
import org.springframework.cloud.servicebroker.model.*;
import org.springframework.cloud.servicebroker.service.ServiceInstanceService;
import org.springframework.stereotype.Service;

@Service
public class HashMapServiceInstanceService implements ServiceInstanceService {
    private Logger logger = Logger.getLogger(HashMapServiceInstanceService.class);

    @Override
    public CreateServiceInstanceResponse createServiceInstance(CreateServiceInstanceRequest createServiceInstanceRequest) {
        logger.debug("Method enter into method createServiceInstance()...");
        return new CreateServiceInstanceResponse();
    }

    @Override
    public GetLastServiceOperationResponse getLastOperation(GetLastServiceOperationRequest getLastServiceOperationRequest) {
        logger.debug("Method enter into method GetLastServiceOperationResponse()...");
        return new GetLastServiceOperationResponse().withOperationState(OperationState.SUCCEEDED);
    }

    @Override
    public DeleteServiceInstanceResponse deleteServiceInstance(DeleteServiceInstanceRequest deleteServiceInstanceRequest) {
        logger.debug("Method enter into method deleteServiceInstance()...");
        return new DeleteServiceInstanceResponse();
    }

    @Override
    public UpdateServiceInstanceResponse updateServiceInstance(UpdateServiceInstanceRequest updateServiceInstanceRequest) {
        logger.debug("Method enter into method updateServiceInstance()...");
        return new UpdateServiceInstanceResponse();
    }
}
