package com.sprint.food_delivery.Exception;

public class DeliveryAddressNotFoundException extends RuntimeException {
    public DeliveryAddressNotFoundException(Integer id) {
        super("Delivery address not found with ID: " + id);
    }
}
