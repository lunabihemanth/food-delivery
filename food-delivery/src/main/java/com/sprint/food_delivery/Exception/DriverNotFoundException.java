package com.sprint.food_delivery.exception;

public class DriverNotFoundException extends RuntimeException {

    public DriverNotFoundException(Integer id) {
        super("Driver not found with id: " + id);
    }
}