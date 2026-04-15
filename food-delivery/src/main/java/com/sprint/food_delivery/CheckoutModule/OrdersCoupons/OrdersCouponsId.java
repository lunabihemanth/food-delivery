package com.sprint.food_delivery.CheckoutModule.OrdersCoupons;

import java.io.Serializable;
import java.util.Objects;

public class OrdersCouponsId implements Serializable {

    private Integer order;
    private Integer coupon;

    public OrdersCouponsId() {}

    public OrdersCouponsId(Integer order, Integer coupon) {
        this.order = order;
        this.coupon = coupon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrdersCouponsId)) return false;
        OrdersCouponsId that = (OrdersCouponsId) o;
        return Objects.equals(order, that.order) &&
               Objects.equals(coupon, that.coupon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, coupon);
    }
}