package com.Ankit.UserMicroService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    private Long id;
    private String hotelName;
    private String address;
    private String about;
}
