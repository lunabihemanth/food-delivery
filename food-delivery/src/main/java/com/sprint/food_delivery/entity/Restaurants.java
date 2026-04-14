package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class Restaurants {
	
	@Id
    @Column(name = "restaurant_id")
    private Integer restaurantId;

    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhone;

}
