package com.sprint.food_delivery.CustomersModule.DeliveryAddress;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Integer> {
    List<DeliveryAddress> findByCustomer_CustomerId(Integer customerId); // fetch by customer
}