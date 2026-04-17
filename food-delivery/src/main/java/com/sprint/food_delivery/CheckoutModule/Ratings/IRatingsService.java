package com.sprint.food_delivery.CheckoutModule.Ratings;

import java.util.List;

public interface IRatingsService {

    Ratings saveForOrder(Integer orderId, Ratings rating);

    List<Ratings> getByRestaurant(Integer restaurantId);

    Ratings findById(Integer id);

    void delete(Integer id);
}