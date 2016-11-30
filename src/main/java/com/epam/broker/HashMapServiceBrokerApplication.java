package com.epam.broker;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class HashMapServiceBrokerApplication {
    public static void main(String[] args){
        new SpringApplicationBuilder().sources(HashMapServiceBrokerApplication.class).run(args);
    }
}
