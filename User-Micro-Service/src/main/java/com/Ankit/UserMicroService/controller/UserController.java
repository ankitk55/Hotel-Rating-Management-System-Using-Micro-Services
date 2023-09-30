package com.Ankit.UserMicroService.controller;

import com.Ankit.UserMicroService.model.Rating;
import com.Ankit.UserMicroService.model.UserEntity;
import com.Ankit.UserMicroService.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    private org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
    int retrycount =1;
    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
@GetMapping("{userId}")
@Retry(name = "RatingHotelRetry",fallbackMethod = "ratingHotelFallBack")
//@CircuitBreaker(name = "RatingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<UserEntity> findById(@PathVariable Long userId){
        retrycount++;
        logger.info("retry count : "+retrycount);
        return ResponseEntity.ok(userService.findUserById(userId));
    }
    public ResponseEntity<UserEntity>ratingHotelFallBack(Long userId, Exception ex){
        UserEntity user = UserEntity.builder().userName("Dummy User")
                .userId((long)88).userEmail("dummy@gmail.com")
                .about("This is Fallback some service is down")
                .build();
        logger.info("Fall Back Method Executed..");
        return ResponseEntity.ok(user);
    }



}
