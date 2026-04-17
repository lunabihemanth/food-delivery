package com.sprint.food_delivery.Exception;

public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String email) {
        super("Customer already exists with email: " + email);
    }
}
