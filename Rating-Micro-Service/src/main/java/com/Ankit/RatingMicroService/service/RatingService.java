package com.Ankit.RatingMicroService.service;

import com.Ankit.RatingMicroService.model.Rating;
import com.Ankit.RatingMicroService.repository.IRatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingService implements IRatingService{
    @Autowired
    IRatingRepo ratingRepo;
    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> gatAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(Long userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(Long hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
