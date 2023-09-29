package com.Ankit.HotelMicroService.repository;

import com.Ankit.HotelMicroService.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHotelRepo extends JpaRepository<Hotel,Long> {
}
