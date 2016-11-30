package com.epam.broker.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomHashMapService {
    private HashMap hashMap = new HashMap();

    public Map getInstance(){
        return hashMap;
    }
}
