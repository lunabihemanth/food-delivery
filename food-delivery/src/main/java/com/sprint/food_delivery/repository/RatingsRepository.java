package com.sprint.food_delivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint.food_delivery.entity.Ratings;

public interface RatingsRepository extends JpaRepository<Ratings, Integer>{

	List<Ratings> findByRestaurantRestaurantId(Integer restaurantId);

}
