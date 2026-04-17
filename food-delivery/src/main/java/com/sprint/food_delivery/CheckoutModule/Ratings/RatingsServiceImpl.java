package com.sprint.food_delivery.CheckoutModule.Ratings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.OrderModule.Orders.Orders;
import com.sprint.food_delivery.OrderModule.Orders.OrderRepository;

@Service
public class RatingsServiceImpl implements IRatingsService {

    @Autowired
    private RatingsRepository ratingRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Ratings saveForOrder(Integer orderId, Ratings rating) {
        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        rating.setOrder(order);
        rating.setRestaurant(order.getRestaurant());

        return ratingRepository.save(rating);
    }

    @Override
    public List<Ratings> getByRestaurant(Integer restaurantId) {
        return ratingRepository.findByRestaurant_RestaurantId(restaurantId);
    }

    @Override
    public Ratings findById(Integer id) {
        return ratingRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        ratingRepository.deleteById(id);
    }
}