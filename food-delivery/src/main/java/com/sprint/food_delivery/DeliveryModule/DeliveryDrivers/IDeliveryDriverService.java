package com.sprint.food_delivery.DeliveryModule.DeliveryDrivers;

import java.util.List;

public interface IDeliveryDriverService {

    DeliveryDriverResponseDTO save(DeliveryDriverRequestDTO dto);

    List<DeliveryDriverResponseDTO> getAll();

    DeliveryDriverResponseDTO findById(Integer id);

    DeliveryDriverResponseDTO update(Integer id, DeliveryDriverRequestDTO dto);

    void delete(Integer id);
}