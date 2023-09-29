package com.Ankit.UserMicroService.controller;

import com.Ankit.UserMicroService.model.Rating;
import com.Ankit.UserMicroService.model.UserEntity;
import com.Ankit.UserMicroService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
@GetMapping("{userId}")
    public ResponseEntity<UserEntity> findById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @PostMapping("/rating")
    public Rating addRating ( Rating rating){
        return userService.addRating(rating);
    }
}
