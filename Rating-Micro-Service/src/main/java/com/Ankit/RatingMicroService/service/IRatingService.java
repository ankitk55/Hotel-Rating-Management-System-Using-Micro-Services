package com.Ankit.RatingMicroService.service;

import com.Ankit.RatingMicroService.model.Rating;

import java.util.List;

public interface IRatingService {
    Rating saveRating(Rating rating);

    List<Rating> gatAllRatings();
    List<Rating> getRatingByUserId(Long userId);
    List<Rating> getRatingByHotelId(Long hotelId);
}
