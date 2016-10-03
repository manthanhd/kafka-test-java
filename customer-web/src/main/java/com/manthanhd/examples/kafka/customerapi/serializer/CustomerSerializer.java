package com.manthanhd.examples.kafka.customerapi.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manthanhd.examples.kafka.customerapi.model.Customer;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by manthanhd on 03/10/2016.
 */
public class CustomerSerializer implements Serializer<Customer>{

    private final ObjectMapper mapper;

    private boolean isKey;
    private Map<String, ?> configs;

    public CustomerSerializer() {
        mapper = new ObjectMapper();
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        this.configs = configs;
        this.isKey = isKey;
    }

    @Override
    public byte[] serialize(String topic, Customer data) {
        try {
            return mapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            System.out.println("Failed to serialize to json bytes.");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void close() {
        System.out.println("Closed serializer.");
    }
}
