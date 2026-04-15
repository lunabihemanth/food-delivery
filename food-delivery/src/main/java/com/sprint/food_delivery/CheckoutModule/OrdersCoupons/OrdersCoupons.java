package com.sprint.food_delivery.CheckoutModule.OrdersCoupons;

import com.sprint.food_delivery.CheckoutModule.Coupons.Coupons;
import com.sprint.food_delivery.OrderModule.Orders.Orders;

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

    
}