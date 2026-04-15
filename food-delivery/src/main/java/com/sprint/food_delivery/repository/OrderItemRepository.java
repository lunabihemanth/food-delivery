package com.sprint.food_delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.food_delivery.entity.OrderItems;

public interface OrderItemRepository extends JpaRepository<OrderItems, Integer>{

}
