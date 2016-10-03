package com.manthanhd.examples.kafka.customerapi.controllers;

import com.manthanhd.examples.kafka.customerapi.dto.CustomerDto;
import com.manthanhd.examples.kafka.customerapi.model.Customer;
import com.manthanhd.examples.kafka.customerapi.services.AsyncCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by manthanhd on 03/10/2016.
 */
@RestController
public class CustomerController {

    @Autowired
    private AsyncCustomerService asyncCustomerService;

    @RequestMapping(path = "/customer", method = RequestMethod.POST)
    public ResponseEntity<Customer> registerCustomer(@RequestBody CustomerDto dto) {
        if(dto.getId() != null) return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);

        final Customer customer = asyncCustomerService.registerCustomer(dto);
        return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);
    }

}
