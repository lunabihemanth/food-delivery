package com.sprint.food_delivery.RatingsModule;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.OrdersModule.Orders.Orders;
import com.sprint.food_delivery.OrdersModule.Orders.OrdersRepository;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.Restaurants;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.RestaurantsRepository;

@Service
public class RatingsService implements IRatingsService {

    @Autowired
    private RatingsRepository ratingsRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private RestaurantsRepository restaurantsRepository;

    // ✅ CREATE
    @Override
    public RatingsResponseDTO save(RatingsRequestDTO dto) {

        Orders order = ordersRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Restaurants restaurant = restaurantsRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        // 🔥 Business Rule: One rating per order
        if (ratingsRepository.existsByOrder_OrderId(dto.getOrderId())) {
            throw new RuntimeException("Rating already exists for this order");
        }

        Ratings rating = new Ratings();
        rating.setOrder(order);
        rating.setRestaurant(restaurant);
        rating.setRating(dto.getRating());
        rating.setReview(dto.getReview());

        Ratings saved = ratingsRepository.save(rating);

        return mapToDTO(saved);
    }

    // ✅ GET ALL
    @Override
    public List<RatingsResponseDTO> getAll() {
        return ratingsRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ✅ GET BY ID
    @Override
    public RatingsResponseDTO findById(Integer ratingId) {

        Ratings rating = ratingsRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Rating not found"));

        return mapToDTO(rating);
    }

    // ✅ GET BY RESTAURANT
    @Override
    public List<RatingsResponseDTO> getByRestaurantId(Integer restaurantId) {

        if (!restaurantsRepository.existsById(restaurantId)) {
            throw new RuntimeException("Restaurant not found");
        }

        return ratingsRepository.findByRestaurant_RestaurantId(restaurantId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ✅ UPDATE
    @Override
    public RatingsResponseDTO update(Integer ratingId, RatingsRequestDTO dto) {

        Ratings existing = ratingsRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Rating not found"));

        Orders order = ordersRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Restaurants restaurant = restaurantsRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        existing.setOrder(order);
        existing.setRestaurant(restaurant);
        existing.setRating(dto.getRating());
        existing.setReview(dto.getReview());

        Ratings updated = ratingsRepository.save(existing);

        return mapToDTO(updated);
    }

    // ✅ DELETE
    @Override
    public void delete(Integer ratingId) {

        if (!ratingsRepository.existsById(ratingId)) {
            throw new RuntimeException("Rating not found");
        }

        ratingsRepository.deleteById(ratingId);
    }

    // 🔁 MAPPER METHOD
    private RatingsResponseDTO mapToDTO(Ratings rating) {
        return new RatingsResponseDTO(
                rating.getRatingId(),
                rating.getOrder().getOrderId(),
                rating.getRestaurant().getRestaurantId(),
                rating.getRating(),
                rating.getReview()
        );
    }
}