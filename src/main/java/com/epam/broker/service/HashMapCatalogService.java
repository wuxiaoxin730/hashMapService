package com.epam.broker.service;

import org.apache.log4j.Logger;
import org.springframework.cloud.servicebroker.model.Catalog;
import org.springframework.cloud.servicebroker.model.Plan;
import org.springframework.cloud.servicebroker.model.ServiceDefinition;
import org.springframework.cloud.servicebroker.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HashMapCatalogService implements CatalogService {
    private Logger logger = Logger.getLogger(HashMapCatalogService.class);

    @Override
    public Catalog getCatalog() {
        logger.debug("Enter in method getCatalog()...");
        return new Catalog(Collections.singletonList(new ServiceDefinition(
                "hashMap-service-broker",
                "myHashMapService",
                "A simple hashMap service broker implementation",
                true,
                false,
                Collections.singletonList(new Plan(
                        "hashmap-plan",
                        "default",
                        "A default hashMap plan",
                        getPlanMetadata())),
                Arrays.asList("Hash Map", "Cloud Storage"),
                getServiceDefinitionMetadata(),
                null,
                null)));
    }

    @Override
    public ServiceDefinition getServiceDefinition(String s) {
        logger.debug("The parameter s is :" + s);
        return new ServiceDefinition();
    }

    private Map<String, Object> getServiceDefinitionMetadata() {
        Map<String, Object> sdMetadata = new HashMap<>();
        sdMetadata.put("displayName", "HashMap");
        sdMetadata.put("imageUrl", "http://www.th7.cn/d/file/p/2016/10/14/fbf5a3e19fb68b85392cb63694bc686c.jpg");
        sdMetadata.put("longDescription", "HashMap Service");
        sdMetadata.put("providerDisplayName", "Pivotal");
        sdMetadata.put("documentationUrl", "https://github.com/wuxiaoxin730");
        sdMetadata.put("supportUrl", "https://github.com/wuxiaoxin730");
        return sdMetadata;
    }

    private Map<String,Object> getPlanMetadata() {
        Map<String,Object> planMetadata = new HashMap<>();
        planMetadata.put("costs", getCosts());
        planMetadata.put("bullets", getBullets());
        planMetadata.put("displayName", "Customized Hash Map");

        return planMetadata;
    }

    private List<Map<String,Object>> getCosts() {
        Map<String,Object> costsMap = new HashMap<>();

        Map<String,Object> amount = new HashMap<>();
        amount.put("CNY", 0.0);

        costsMap.put("amount", amount);
        costsMap.put("unit", "MONTHLY");

        return Collections.singletonList(costsMap);
    }

    private List<String> getBullets() {
        return Arrays.asList("Shared Hash Map",
                "can put element",
                "can get element");
    }
}
