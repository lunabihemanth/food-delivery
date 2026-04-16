package com.sprint.food_delivery.CustomersModule.Customers;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Integer id) {
        super("Customer not found with ID: " + id);
    }
}