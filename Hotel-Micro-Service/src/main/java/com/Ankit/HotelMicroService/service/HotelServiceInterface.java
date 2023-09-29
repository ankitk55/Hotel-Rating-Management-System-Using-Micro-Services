package com.Ankit.HotelMicroService.service;

import com.Ankit.HotelMicroService.model.Hotel;

import java.util.List;

public interface HotelServiceInterface {
    Hotel saveHotel(Hotel hotel);
    List<Hotel> getAllHotel();
    Hotel getHotelById(Long id);
}
