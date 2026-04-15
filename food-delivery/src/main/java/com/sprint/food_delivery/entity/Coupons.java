package com.sprint.food_delivery.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class Coupons {
	
	@Id
    @Column(name = "coupon_id")
    private Integer couponId;

    @Column(name = "coupon_code", unique = true)
    private String couponCode;

    @Column(name = "discount_amount")
    private Double discountAmount;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;
	
}
