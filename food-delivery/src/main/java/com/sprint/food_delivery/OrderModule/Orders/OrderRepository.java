package com.sprint.food_delivery.OrderModule.Orders;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

    
    List<Orders> findByDeliveryDriverDriverId(Integer driverId);

   
    List<Orders> findByCustomerCustomerId(Integer customerId);

    
    List<Orders> findByRestaurantRestaurantId(Integer restaurantId);
}