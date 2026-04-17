package com.sprint.food_delivery.OrderModule.Orders;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrdersRequestDTO {

    @NotNull(message = "Customer ID cannot be null")
    private Integer customerId;

    @NotNull(message = "Restaurant ID cannot be null")
    private Integer restaurantId;

    private Integer deliveryDriverId;

    @NotBlank(message = "Order status cannot be empty")
    private String orderStatus;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getDeliveryDriverId() {
        return deliveryDriverId;
    }

    public void setDeliveryDriverId(Integer deliveryDriverId) {
        this.deliveryDriverId = deliveryDriverId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // getters & setters
}