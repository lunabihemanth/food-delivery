package com.sprint.food_delivery.CustomersModule.DeliveryAddress;

public class DeliveryAddressNotFoundException extends RuntimeException {
    public DeliveryAddressNotFoundException(Integer id) {
        super("Delivery address not found with ID: " + id);
    }
}
