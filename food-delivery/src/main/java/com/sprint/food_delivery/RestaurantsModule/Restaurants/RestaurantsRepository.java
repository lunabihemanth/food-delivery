
package com.sprint.food_delivery.RestaurantsModule.Restaurants;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import java.util.List;

public interface RestaurantsRepository extends JpaRepository<Restaurants, Integer> {

    @Query("SELECT r FROM Restaurants r WHERE r.restaurantName = :name")
    List<Restaurants> getByRestaurantName(@Param("name") String name);

    @Query("SELECT r FROM Restaurants r WHERE r.restaurantPhone = :phone")
    Restaurants getByPhone(@Param("phone") String phone);

    @Modifying
    @Transactional
    @Query("UPDATE Restaurants r SET r.restaurantPhone = :phone WHERE r.restaurantId = :id")
    int updateRestaurantPhone(@Param("id") Integer id,
                              @Param("phone") String phone);

    @Modifying
    @Transactional
    @Query("DELETE FROM Restaurants r WHERE r.restaurantId = :id")
    int deleteRestaurant(@Param("id") Integer id);
}

