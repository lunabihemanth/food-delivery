package com.sprint.food_delivery.CustomersModule.Customers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers, Integer> {
    boolean existsByCustomerEmail(String email);  
    Customers findByCustomerEmail(String email);
}