package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity

public class Restaurants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private Integer restaurantId;
	
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhone;
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
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	public String getRestaurantPhone() {
		return restaurantPhone;
	}
	public void setRestaurantPhone(String restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}

}
