package com.Ankit.UserMicroService.service;

import com.Ankit.UserMicroService.external.service.HotelService;
import com.Ankit.UserMicroService.external.service.RatingService;
import com.Ankit.UserMicroService.model.Hotel;
import com.Ankit.UserMicroService.model.Rating;
import com.Ankit.UserMicroService.model.UserEntity;
import com.Ankit.UserMicroService.repository.IUserRepo;
import com.Ankit.UserMicroService.service.exceptions.userNotFoundException;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;
    @Autowired
  private   RestTemplate restTemplate;

    @Autowired
    private RatingService ratingService;
    @Autowired
    private HotelService hotelService;

  private   Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserEntity saveUser(UserEntity user){
        return userRepo.save(user);
    }
    public List<UserEntity> getAllUser(){
            List<UserEntity> userEntityList =userRepo.findAll();
            for(UserEntity user: userEntityList){
                Rating [] ratin = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getUserId(), Rating [].class);
                List<Rating> ratings = Arrays.stream(ratin).toList();
                for(Rating rating:ratings){
                    Hotel hotel =restTemplate.getForObject("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
                    rating.setHotel(hotel);
                }
            user.setRatingList(ratings);
            }

        return userEntityList;
    }
    public UserEntity findUserById(Long id){
        UserEntity user = userRepo.findById(id).orElseThrow(()-> new userNotFoundException("User not found "));

     /*  call by the Rest Template
       Rating [] ratin = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getUserId(), Rating [].class);
      List<Rating> ratings = Arrays.stream(ratin).toList(); */

        List<Rating>ratings =ratingService.getRatings(user.getUserId());

       for(Rating rating:ratings){
           //Hotel hotel =restTemplate.getForObject("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
           Hotel hotel = hotelService.getHotel(rating.getHotelId());
           rating.setHotel(hotel);
       }

       user.setRatingList(ratings);

        return user;
    }

    public Rating addRating(Rating rating) {
      return   ratingService.addRating(rating);


    }
}
