package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class MenuItems {
	@Id
    @Column(name = "item_id")
    private Integer itemId;

    private String itemName;
    private String itemDescription;
    private Double itemPrice;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurants restaurant;
}
