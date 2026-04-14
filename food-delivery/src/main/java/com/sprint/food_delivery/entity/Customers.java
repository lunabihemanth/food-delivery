package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class Customers {
	
	@Id
    @Column(name = "customer_id")
    private Integer customerId;

    private String customerName;
    private String customerEmail;
    private String customerPhone;
}
