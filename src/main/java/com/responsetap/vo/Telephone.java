package com.responsetap.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Telephone {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Telephone.class);

    private String id;
    private String telephoneNumber;

    public Telephone() {}
    
    public Telephone(String id, String telephoneNumber) {
        this.id = id;
        this.telephoneNumber = telephoneNumber; 
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();        
        try {
            return ow.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error trying to parse to JSON", e);
            return super.toString();
        }
    }
    
}
