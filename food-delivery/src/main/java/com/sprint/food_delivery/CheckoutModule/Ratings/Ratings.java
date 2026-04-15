package com.sprint.food_delivery.CheckoutModule.Ratings;

import com.sprint.food_delivery.OrderModule.Orders.Orders;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.Restaurants;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ratings")
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Integer ratingId;

    @NotNull(message = "Rating value is required")
    @Column(name = "rating_value")
    private Integer ratingValue;

    @Column(name = "review")
    private String review;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @NotNull(message = "Restaurant is required")
    private Restaurants restaurant;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @NotNull(message = "Order is required")
    private Orders order;

    // Getters and Setters

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