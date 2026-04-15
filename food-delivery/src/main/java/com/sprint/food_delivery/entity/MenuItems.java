package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity

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

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Restaurants getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurants restaurant) {
		this.restaurant = restaurant;
	}
}
