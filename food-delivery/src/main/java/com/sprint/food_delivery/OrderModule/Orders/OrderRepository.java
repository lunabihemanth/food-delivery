package com.sprint.food_delivery.OrderModule.Orders;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.food_delivery.OrderModule.Orders.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

	List<Orders> findByDeliveryDriverDriverId(Integer driverId);

}
