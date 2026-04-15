package com.sprint.food_delivery.CustomersModule.Customers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.food_delivery.CustomersModule.Customers.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Integer> {
	Customers findByCustomerEmail(String email);
}