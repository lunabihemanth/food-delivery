package com.sprint.food_delivery.RatingsModule;

import java.util.List;

public interface IRatingsService {

    RatingsResponseDTO save(RatingsRequestDTO dto);

    List<RatingsResponseDTO> getAll();

    RatingsResponseDTO findById(Integer ratingId);

    List<RatingsResponseDTO> getByRestaurantId(Integer restaurantId);

    RatingsResponseDTO update(Integer ratingId, RatingsRequestDTO dto);

    void delete(Integer ratingId);
}