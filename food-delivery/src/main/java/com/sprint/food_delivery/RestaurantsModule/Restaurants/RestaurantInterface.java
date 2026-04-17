package com.sprint.food_delivery.RestaurantsModule.Restaurants;

import java.util.List;

public interface RestaurantInterface {
    Restaurants save(Restaurants restaurant);

    List<Restaurants> getAll();

    Restaurants findById(Integer id);

    Restaurants update(Integer id, Restaurants restaurant);

    void delete(Integer id);
}
