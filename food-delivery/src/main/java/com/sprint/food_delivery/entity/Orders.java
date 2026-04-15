package com.sprint.food_delivery.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity

public class Orders {
	@Id
    @Column(name = "order_id")
    private Integer orderId;
	
	@NotNull(message ="Order date cannot be null")
    private LocalDateTime orderDate;
	
	@NotBlank(message="Order status cannot be empty")
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull(message ="Customer id is required")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @NotNull(message ="Restaurant id is required")
    private Restaurants restaurant;

    @ManyToOne
    @JoinColumn(name = "delivery_driver_id")
    private DeliveryDrivers deliveryDriver;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Restaurants getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurants restaurant) {
		this.restaurant = restaurant;
	}

	public DeliveryDrivers getDeliveryDriver() {
		return deliveryDriver;
	}

	public void setDeliveryDriver(DeliveryDrivers deliveryDriver) {
		this.deliveryDriver = deliveryDriver;
	}

}
