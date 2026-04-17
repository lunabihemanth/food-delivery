package com.sprint.food_delivery.DeliveryModule.DeliveryDrivers;

import java.util.List;

public interface IDeliveryDriversService {

    DeliveryDriversResponseDTO save(DeliveryDriversRequestDTO dto);

    List<DeliveryDriversResponseDTO> getAll();

    DeliveryDriversResponseDTO findById(Integer id);

    DeliveryDriversResponseDTO update(Integer id, DeliveryDriversRequestDTO dto);

    void delete(Integer id);
}