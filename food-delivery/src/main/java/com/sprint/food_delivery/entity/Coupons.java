package com.sprint.food_delivery.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity

public class Coupons {
	
	@Id
    @Column(name = "coupon_id")
    private Integer couponId;

    private String couponCode;
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
	public Double getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	public java.time.LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(java.time.LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	private Double discountAmount;
    private java.time.LocalDate expiryDate;
    
    @OneToMany(mappedBy = "coupon")
    private Set<OrdersCoupons> orderCoupons;
	
}
