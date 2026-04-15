package com.sprint.food_delivery.CheckoutModule.Ratings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.food_delivery.CheckoutModule.Ratings.Ratings;

public interface RatingsRepository extends JpaRepository<Ratings, Integer>{

	List<Ratings> findByRestaurantRestaurantId(Integer restaurantId);

}
