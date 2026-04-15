package com.sprint.food_delivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sprint.food_delivery.entity.DeliveryAddresses;
@Service
public interface DeliveryAddressService {
    DeliveryAddresses addAddress(DeliveryAddresses address);

    DeliveryAddresses updateAddress(Integer id, DeliveryAddresses address);

    void deleteAddress(Integer id);

    DeliveryAddresses getAddressById(Integer id);

    List<DeliveryAddresses> getAllAddresses();

}
