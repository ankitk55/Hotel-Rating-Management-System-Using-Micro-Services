package com.Ankit.HotelMicroService.service.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class apiResponse {
    private  String message;
    private boolean status;
    private HttpStatus httpStatus;

}
