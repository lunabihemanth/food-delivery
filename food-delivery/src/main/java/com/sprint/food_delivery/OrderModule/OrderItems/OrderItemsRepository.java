package com.sprint.food_delivery.OrderModule.OrderItems;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderItemsRepository  extends JpaRepository<OrderItems, Integer>{
	List<OrderItems> findByOrderOrderId(Integer orderId);
}
