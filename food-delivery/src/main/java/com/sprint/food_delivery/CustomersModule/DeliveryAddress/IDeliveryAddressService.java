package com.sprint.food_delivery.CustomersModule.DeliveryAddress;

import java.util.List;

public interface IDeliveryAddressService {

    DeliveryAddressResponseDTO save(DeliveryAddressRequestDTO dto);

    List<DeliveryAddressResponseDTO> getAll();

    DeliveryAddressResponseDTO findById(Integer id);

    List<DeliveryAddressResponseDTO> getByCustomerId(Integer customerId);

    DeliveryAddressResponseDTO update(Integer id, DeliveryAddressRequestDTO dto);

    void delete(Integer id);
}