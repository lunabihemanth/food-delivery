package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class Orders {
	@Id
    @Column(name = "order_id")
    private Integer orderId;

    private java.time.LocalDateTime orderDate;
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurants restaurant;

    @ManyToOne
    @JoinColumn(name = "delivery_driver_id")
    private DeliveryDrivers deliveryDriver;

}
