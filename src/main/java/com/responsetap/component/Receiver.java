package com.responsetap.component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.responsetap.vo.Telephone;

@Component
public class Receiver {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private int count = 0;
    private Map<String, List<String>> map = new HashMap<>();
    
    
    public void receiveMessage(String message) {
        
        LOGGER.info("Message received: {}", message);
        count++;
        LOGGER.info("Number of items received: {}", count);
        
        Telephone telephone = null;
        try {
            telephone = this.getObject(message);
        } catch (IOException e) {
            LOGGER.error("Error trying to get object from JSON", e);
            telephone = new Telephone("NA", "+ERROR");
        }
        
        String telephoneNumber = telephone.getTelephoneNumber();
        String country = getCountry(telephoneNumber);
        if (map.containsKey(country)) {
            map.get(country).add(telephoneNumber);
        } else {
            map.put(country, Lists.newArrayList(telephoneNumber));
        }

    }


    private String getCountry(String telephoneNumber) {
        String country = "UK";
        if (telephoneNumber.startsWith("+44")) {
            country = "UK";
        } else if (telephoneNumber.startsWith("+1")) {
            country = "US";
        } else if (telephoneNumber.startsWith("+54")) {
            country = "AR";
        } else if (telephoneNumber.startsWith("+39")) {
            country = "IT";
        } else if (telephoneNumber.startsWith("+ERROR")) {
            country = "ERR";
        }
        return country;
    }
    
    private Telephone getObject(String message) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(message, Telephone.class);
    }
}
