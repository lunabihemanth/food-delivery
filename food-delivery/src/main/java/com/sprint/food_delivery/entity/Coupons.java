package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Coupons {

    @Id
    @Column(name = "coupon_id")
    private Integer couponId;

    @NotBlank(message = "Coupon code cannot be empty")
    private String couponCode;

    @NotNull(message = "Discount percentage is required")
    private Double discount;

    @NotBlank(message = "Coupon status cannot be empty")
    private String status;

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}