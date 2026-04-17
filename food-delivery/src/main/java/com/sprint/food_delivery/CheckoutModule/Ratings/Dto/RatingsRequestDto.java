package com.sprint.food_delivery.CheckoutModule.Ratings.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RatingsRequestDto {
    @NotNull(message = "Rating value is required")
        @Min(value = 1, message = "Rating must be at least 1")
        @Max(value = 5, message = "Rating must be at most 5")
        private Integer ratingValue;
    
        
        private String review; 

    
        public Integer getRatingValue() { return ratingValue; }
        public void setRatingValue(Integer ratingValue) { this.ratingValue = ratingValue; }
        public String getReview() { return review; }
        public void setReview(String review) { this.review = review; }
    }
    