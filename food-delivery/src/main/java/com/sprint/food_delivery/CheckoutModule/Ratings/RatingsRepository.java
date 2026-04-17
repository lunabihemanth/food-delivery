package com.sprint.food_delivery.CheckoutModule.Ratings;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



public interface RatingsRepository extends JpaRepository<Ratings, Integer>{

	

	    List<Ratings> findByRestaurantRestaurantId(Integer restaurantId);

	    @Query("SELECT r FROM Ratings r WHERE r.restaurant.restaurantId = :restaurantId AND r.rating > :rating")
	    List<Ratings> findHighRatingsByRestaurant(@Param("restaurantId") Integer restaurantId,
	                                              @Param("rating") double rating);

	    @Query("SELECT AVG(r.rating) FROM Ratings r WHERE r.restaurant.restaurantId = :restaurantId")
	    Double getAverageRatingByRestaurant(@Param("restaurantId") Integer restaurantId);

	    @Modifying
	    @Transactional
	    @Query("UPDATE Ratings r SET r.rating = :rating WHERE r.ratingId = :id")
	    int updateRatingValue(@Param("id") Integer id,
	                          @Param("rating") double rating);
	}



