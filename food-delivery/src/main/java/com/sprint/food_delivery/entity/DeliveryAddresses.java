package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DeliveryAddresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAddresses {

    @Id
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "address_line1")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    private String city;
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;
}