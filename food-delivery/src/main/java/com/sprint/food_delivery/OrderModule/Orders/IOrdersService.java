package com.sprint.food_delivery.ordermodule.orders;

import java.util.List;

public interface IOrdersService {
    OrdersResponseDTO save(OrdersRequestDTO dto);
    List<OrdersResponseDTO> getAll();
    OrdersResponseDTO findById(Integer id);
    List<OrdersResponseDTO> getByCustomerId(Integer customerId);
    OrdersResponseDTO update(Integer id, OrdersRequestDTO dto);
    String delete(Integer id);
    List<OrdersResponseDTO> getByRestaurantId(Integer restaurantId);
}