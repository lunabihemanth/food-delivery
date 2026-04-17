package com.sprint.food_delivery.CheckoutModule.Ratings;

import com.sprint.food_delivery.OrderModule.Orders.Orders;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.Restaurants;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ratings")
@NoArgsConstructor
@AllArgsConstructor
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratingId;

    @NotNull
    private Integer ratingValue;

    private String review;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Restaurants restaurant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Orders order;

    
    public Integer getRatingId() { return ratingId; }
    public void setRatingId(Integer ratingId) { this.ratingId = ratingId; }

    public Integer getRatingValue() { return ratingValue; }
    public void setRatingValue(Integer ratingValue) { this.ratingValue = ratingValue; }

    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

    public Restaurants getRestaurant() { return restaurant; }
    public void setRestaurant(Restaurants restaurant) { this.restaurant = restaurant; }

    public Orders getOrder() { return order; }
    public void setOrder(Orders order) { this.order = order; }
}