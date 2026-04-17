package com.sprint.food_delivery.OrderModule.Orders;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    // ✅ Derived
    List<Orders> findByCustomer_CustomerId(Integer customerId);

    // --------------------------------------------

    // ✅ Custom SELECT
    @Query("SELECT o FROM Orders o WHERE o.orderStatus = :status")
    List<Orders> findByStatus(@Param("status") String status);

    // --------------------------------------------

    // ✅ Custom MODIFY
    @Modifying
    @Transactional
    @Query("UPDATE Orders o SET o.orderStatus = :status WHERE o.orderId = :id")
    int updateOrderStatus(@Param("id") Integer id,
                          @Param("status") String status);
}