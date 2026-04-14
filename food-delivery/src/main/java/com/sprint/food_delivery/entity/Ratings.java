package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class Ratings {
	
	@Id
    @Column(name = "rating_id")
    private Integer ratingId;

    private Integer rating;
    private String review;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurants restaurant;

}
