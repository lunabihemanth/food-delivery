 package com.sprint.food_delivery.CustomersModule.DeliveryAddress;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressService {

    @Autowired
    private DeliveryAddressRepository repo;

    public DeliveryAddress save(DeliveryAddress address) {
        return repo.save(address);
    }

    public List<DeliveryAddress> getAll() {
        return repo.findAll();
    }

    public DeliveryAddress getById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public DeliveryAddress update(Integer id, DeliveryAddress newAddress) {
        DeliveryAddress existing = getById(id);

        existing.setAddressLine1(newAddress.getAddressLine1());
        existing.setAddressLine2(newAddress.getAddressLine2());
        existing.setCity(newAddress.getCity());
        existing.setState(newAddress.getState());
        existing.setPostalCode(newAddress.getPostalCode());

        return repo.save(existing);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}