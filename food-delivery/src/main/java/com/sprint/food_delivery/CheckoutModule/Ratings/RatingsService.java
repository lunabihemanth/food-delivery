package com.sprint.food_delivery.CheckoutModule.Ratings;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.food_delivery.OrderModule.Orders.Orders;
import com.sprint.food_delivery.OrderModule.Orders.OrdersRepository;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.Restaurants;
import com.sprint.food_delivery.RestaurantsModule.Restaurants.RestaurantsRepository;

import jakarta.transaction.Transactional;

@Service
public class RatingsService implements IRatingsService {

    @Autowired
    private RatingsRepository ratingsRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private RestaurantsRepository restaurantsRepository;

    //Create
    @Override
    public RatingsResponseDTO save(RatingsRequestDTO dto) {

        Orders order = ordersRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Restaurants restaurant = restaurantsRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Ratings rating = new Ratings();
        rating.setOrder(order);
        rating.setRestaurant(restaurant);
        rating.setRating(dto.getRating());
        rating.setReview(dto.getReview());

        return map(ratingsRepository.save(rating));
    }

    // GET ALL
    @Override
    public List<RatingsResponseDTO> getAll() {
        return ratingsRepository.findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    // GET BY ID
    @Override
    public RatingsResponseDTO findById(Integer ratingId) {

        Ratings rating = ratingsRepository.findById(ratingId)
                .orElseThrow(() -> new RuntimeException("Rating not found"));

        return map(rating);
    }

    // GET BY RESTAURANT
    @Override
    public List<RatingsResponseDTO> getByRestaurantId(Integer restaurantId) {

        return ratingsRepository.findByRestaurantRestaurantId(restaurantId)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    // CUSTOM: HIGH RATINGS
    @Override
    public List<RatingsResponseDTO> getHighRatings(Integer restaurantId, double rating) {

        return ratingsRepository.findHighRatingsByRestaurant(restaurantId, rating)
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    // CUSTOM: AVERAGE RATING
    @Override
    public Double getAverageRating(Integer restaurantId) {
        return ratingsRepository.getAverageRatingByRestaurant(restaurantId);
    }

    // UPDATE (FULL ENTITY)
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

        return map(ratingsRepository.save(existing));
    }

    // UPDATE (USING CUSTOM QUERY)
    @Override
    @Transactional
    public String updateRatingValue(Integer ratingId, double rating) {

        int updatedRows = ratingsRepository.updateRatingValue(ratingId, rating);

        if (updatedRows == 0) {
            throw new RuntimeException("Rating not found");
        }

        return "Rating updated successfully for ID: " + ratingId;
    }

    // DELETE
    @Override
    public String delete(Integer ratingId) {

        if (!ratingsRepository.existsById(ratingId)) {
            throw new RuntimeException("Rating not found");
        }

        ratingsRepository.deleteById(ratingId);
        return "Deleted rating with ID: " + ratingId;
    }

    // MAPPER
    private RatingsResponseDTO map(Ratings rating) {
        return new RatingsResponseDTO(
                rating.getRatingId(),
                rating.getOrder().getOrderId(),
                rating.getRestaurant().getRestaurantId(),
                rating.getRating(),
                rating.getReview()
        );
    }
}