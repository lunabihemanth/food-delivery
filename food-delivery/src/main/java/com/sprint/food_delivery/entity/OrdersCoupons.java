package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class OrdersCoupons {
	@EmbeddedId
    private OrderCouponId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @MapsId("couponId")
    @JoinColumn(name = "coupon_id")
    private Coupons coupon;

}
