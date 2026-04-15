package com.sprint.food_delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.entity.Orders;
import com.sprint.food_delivery.entity.Ratings;
import com.sprint.food_delivery.repository.OrderRepository;
import com.sprint.food_delivery.repository.RatingsRepository;

@Service
public class RatingsService {
	@Autowired
	private RatingsRepository ratingRepository;
	
    @Autowired
    private OrderRepository orderRepository; // to link rating to order

    // Save rating and auto-link it to the order
    public Ratings saveForOrder(Integer orderId, Ratings rating) {
        Orders order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            rating.setOrder(order);
            rating.setRestaurant(order.getRestaurant()); // auto-fill restaurant too
        }
        return ratingRepository.save(rating);
    }

    public List<Ratings> getByRestaurant(Integer restaurantId) {
        return ratingRepository.findByRestaurantRestaurantId(restaurantId);
    }

    public Ratings findById(Integer id) {
        return ratingRepository.findById(id).orElse(null);
    }

    public void delete(Integer id) {
        ratingRepository.deleteById(id);
    }
}


