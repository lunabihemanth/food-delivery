package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class DeliveryAddresses {

	@Id
    @Column(name = "address_id")
    private Integer addressId;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;
}
