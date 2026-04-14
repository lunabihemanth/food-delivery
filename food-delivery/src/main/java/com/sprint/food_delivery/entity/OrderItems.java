package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class OrderItems {
	
	@Id
    @Column(name = "order_item_id")
    private Integer orderItemId;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private MenuItems menuItem;

}
