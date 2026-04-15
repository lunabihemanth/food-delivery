package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "coupons")
public class Coupons {

    @Id
    @Column(name = "coupon_id")
    private Integer couponId;

    @NotBlank(message = "Coupon code cannot be empty")
    @Column(name = "coupon_code", unique = true)
    private String couponCode;

    @NotNull(message = "Discount is required")
    @Column(name = "discount_amount")
    private Double discount;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @NotBlank(message = "Coupon status cannot be empty")
    @Column(name = "status")
    private String status;

    // Getters and Setters

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

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}