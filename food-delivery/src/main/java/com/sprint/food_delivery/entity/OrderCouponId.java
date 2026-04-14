package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter @Setter
public class OrderCouponId implements java.io.Serializable {
    private Integer orderId;
    private Integer couponId;
}
