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

    private String couponCode;
    private Double discountAmount;
    private java.time.LocalDate expiryDate;
	
}
