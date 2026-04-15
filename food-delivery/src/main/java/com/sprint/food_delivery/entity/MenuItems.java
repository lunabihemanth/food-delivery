package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class MenuItems {

    @Id
    @Column(name = "item_id")
    private Integer itemId;

    @NotBlank(message = "Item name cannot be empty")
    private String itemName;

    @NotNull(message = "Price is required")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @NotNull(message = "Restaurant is required")
    private Restaurants restaurant;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Restaurants getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurant = restaurant;
    }
}