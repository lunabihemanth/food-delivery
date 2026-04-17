package com.sprint.food_delivery.CheckoutModule.Ratings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingsRepository extends JpaRepository<Ratings, Integer> {

    List<Ratings> findByRestaurant_RestaurantId(Integer restaurantId);
}