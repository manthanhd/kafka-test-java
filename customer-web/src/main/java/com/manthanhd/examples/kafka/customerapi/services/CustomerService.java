package com.manthanhd.examples.kafka.customerapi.services;

import com.manthanhd.examples.kafka.customerapi.dto.CustomerDto;
import com.manthanhd.examples.kafka.customerapi.model.Customer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by manthanhd on 03/10/2016.
 */
@Component
public class CustomerService implements AsyncCustomerService {

    public static final String TOPIC_NAME = "CustomerRegistration";

    @Autowired
    private Producer<String, Customer> producer;

    @Override
    public Customer registerCustomer(CustomerDto dto) {
        final Customer customer = Customer.newBuilder()
                                    .emailAddress(dto.getEmail_address())
                                    .firstName(dto.getFirst_name())
                                    .lastName(dto.getLast_name())
                                    .id(UUID.randomUUID().toString())
                                    .build();
        final ProducerRecord<String, Customer> record = new ProducerRecord<String, Customer>(TOPIC_NAME, customer);
        producer.send(record);
        return customer;
    }
}
