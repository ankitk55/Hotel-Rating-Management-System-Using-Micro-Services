package com.Ankit.RatingMicroService.controller;

import com.Ankit.RatingMicroService.model.Rating;
import com.Ankit.RatingMicroService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rating")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> saverating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
    }
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.ok(ratingService.gatAllRatings());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>>getRatingByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>>getRatingByHotelId(@PathVariable Long hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }
}
