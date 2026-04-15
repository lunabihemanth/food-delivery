package com.sprint.food_delivery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
<<<<<<< HEAD
=======

>>>>>>> 1c508e256c765be8bb706072d32cc2a111cfea0c
public class Ratings {

    @Id
    @Column(name = "rating_id")
    private Integer ratingId;

    @NotNull(message = "Rating value is required")
    private Integer ratingValue;

    private String review;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @NotNull(message = "Restaurant is required")
    private Restaurants restaurant;

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "order_id")
    @NotNull(message = "Order is required")
    private Orders order;

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(Integer ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Restaurants getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
=======
	public Integer getRatingId() {
		return ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Restaurants getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurants restaurant) {
		this.restaurant = restaurant;
	}
    
    

}
>>>>>>> 1c508e256c765be8bb706072d32cc2a111cfea0c
