package com.sprint.food_delivery.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OrdersCoupons")
@IdClass(OrdersCouponsId.class)
public class OrdersCoupons {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @Id
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupons coupon;

    // getters & setters
}