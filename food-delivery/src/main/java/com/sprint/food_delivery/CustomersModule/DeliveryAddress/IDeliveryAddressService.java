package com.sprint.food_delivery.CustomersModule.DeliveryAddress;

import java.util.List;

public interface IDeliveryAddressService {
    DeliveryAddress save(DeliveryAddressDTO dto);
    List<DeliveryAddress> getAll();
    DeliveryAddress getById(Integer id);
    List<DeliveryAddress> getByCustomerId(Integer customerId);
    DeliveryAddress update(Integer id, DeliveryAddressDTO dto);
    void delete(Integer id);
}
