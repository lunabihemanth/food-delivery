package com.sprint.food_delivery.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.entity.DeliveryAddresses;
import com.sprint.food_delivery.repository.DeliveryAddressRepository;
import com.sprint.food_delivery.service.DeliveryAddressService;

@Service
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    @Autowired
    private DeliveryAddressRepository repository;

    @Override
    public DeliveryAddresses addAddress(DeliveryAddresses address) {
        return repository.save(address);
    }

    @Override
    public DeliveryAddresses updateAddress(Integer id, DeliveryAddresses address) {
        return null;
    }

    @Override
    public void deleteAddress(Integer id) {}

    @Override
    public DeliveryAddresses getAddressById(Integer id) {
        return null;
    }

    @Override
    public java.util.List<DeliveryAddresses> getAllAddresses() {
        return null;
    }
}