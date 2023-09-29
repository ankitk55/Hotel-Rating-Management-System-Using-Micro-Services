package com.Ankit.HotelMicroService.service;

import com.Ankit.HotelMicroService.model.Hotel;
import com.Ankit.HotelMicroService.repository.IHotelRepo;
import com.Ankit.HotelMicroService.exceptions.HotelNtFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService implements HotelServiceInterface {
    @Autowired
    IHotelRepo hotelRepo;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepo.findById(id).orElseThrow(()->new HotelNtFoundException("Hotel Not found this id : "+id));
    }
}
