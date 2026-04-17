package com.sprint.food_delivery.OrderModule.OrderItems;

import java.util.List;

public interface IOrderItemsService {

    OrderItemsResponseDTO save(OrderItemsRequestDTO dto);

    List<OrderItemsResponseDTO> getAll();

    OrderItemsResponseDTO findById(Integer id);

    OrderItemsResponseDTO update(Integer id, OrderItemsRequestDTO dto);

    String delete(Integer id);
}