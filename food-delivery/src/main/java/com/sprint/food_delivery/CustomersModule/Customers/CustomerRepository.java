package com.sprint.food_delivery.CustomersModule.Customers;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customers, Integer> {
    boolean existsByCustomerEmail(String email); 
    Customers findByCustomerEmail(String email);

     @Query("SELECT c FROM Customers c WHERE c.customerEmail = :email")
    Optional<Customers> findCustomerByEmail(@Param("email") String email);
}