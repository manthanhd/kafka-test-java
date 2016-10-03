package com.manthanhd.examples.kafka.customerapi.services;

import com.manthanhd.examples.kafka.customerapi.dto.CustomerDto;
import com.manthanhd.examples.kafka.customerapi.model.Customer;

/**
 * Created by manthanhd on 03/10/2016.
 */
public interface AsyncCustomerService {
    Customer registerCustomer(CustomerDto dto);
}
