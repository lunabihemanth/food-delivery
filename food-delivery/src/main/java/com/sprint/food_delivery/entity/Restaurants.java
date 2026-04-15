package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Restaurants {

    @Id
    @Column(name = "restaurant_id")
    private Integer restaurantId;

    @NotBlank(message = "Restaurant name cannot be empty")
    private String restaurantName;

    @NotBlank(message = "Location cannot be empty")
    private String location;

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}