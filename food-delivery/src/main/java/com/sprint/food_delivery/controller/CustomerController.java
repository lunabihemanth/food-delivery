package com.sprint.food_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.food_delivery.entity.Customers;
import com.sprint.food_delivery.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@RestController
@RequestMapping("/customers")

public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public Customers addCustomer(@RequestBody Customers customer) {
        return service.addCustomer(customer);
    }
}
