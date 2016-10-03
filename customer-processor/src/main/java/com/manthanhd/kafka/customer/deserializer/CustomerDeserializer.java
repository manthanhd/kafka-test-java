package com.manthanhd.kafka.customer.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manthanhd.kafka.customer.model.Customer;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

/**
 * Created by manthanhd on 03/10/2016.
 */
public class CustomerDeserializer implements Deserializer<Customer> {

    private final ObjectMapper mapper;
    private boolean isKey;
    private Map<String, ?> configs;

    public CustomerDeserializer() {
        mapper = new ObjectMapper();
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        this.configs = configs;
        this.isKey = isKey;
    }

    @Override
    public Customer deserialize(String topic, byte[] data) {
        try {
            return mapper.readValue(data, Customer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() {

    }
}
