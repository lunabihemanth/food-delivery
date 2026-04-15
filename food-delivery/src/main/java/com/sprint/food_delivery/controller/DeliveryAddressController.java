package com.sprint.food_delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.food_delivery.entity.DeliveryAddresses;
import com.sprint.food_delivery.service.DeliveryAddressService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/deliveryaddresses")
public class DeliveryAddressController {

    @Autowired
    private DeliveryAddressService service;

    @PostMapping
    public DeliveryAddresses addAddress(@RequestBody DeliveryAddresses address) {
        return service.addAddress(address);
    }
}