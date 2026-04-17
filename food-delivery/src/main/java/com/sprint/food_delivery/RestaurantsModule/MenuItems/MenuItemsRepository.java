package com.sprint.food_delivery.RestaurantsModule.MenuItems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import java.util.List;

public interface MenuItemsRepository extends JpaRepository<MenuItems, Integer> {

    @Query("SELECT m FROM MenuItems m WHERE m.restaurant.restaurantId = :restaurantId")
    List<MenuItems> getItemsByRestaurantId(@Param("restaurantId") Integer restaurantId);

    @Query("SELECT m FROM MenuItems m WHERE m.itemName = :name")
    List<MenuItems> getByItemName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE MenuItems m SET m.price = :price WHERE m.itemId = :id")
    int updatePrice(@Param("id") Integer id,
            @Param("price") Double price);

    @Modifying
    @Transactional
    @Query("UPDATE MenuItems m SET m.description = :desc WHERE m.itemId = :id")
    int updateDescription(@Param("id") Integer id,
            @Param("desc") String desc);

    @Modifying
    @Transactional
    @Query("DELETE FROM MenuItems m WHERE m.itemId = :id")
    int deleteMenuItem(@Param("id") Integer id);
}