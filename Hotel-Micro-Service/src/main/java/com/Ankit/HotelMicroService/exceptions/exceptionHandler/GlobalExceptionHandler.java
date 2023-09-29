package com.Ankit.HotelMicroService.exceptions.exceptionHandler;

import com.Ankit.HotelMicroService.exceptions.HotelNtFoundException;
import com.Ankit.HotelMicroService.service.payload.apiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HotelNtFoundException.class)
    public ResponseEntity<apiResponse> hotelNotFound(HotelNtFoundException ex){
        String mess =ex.getMessage();
        apiResponse ap =apiResponse.builder().status(true).message(mess).httpStatus(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ap);
    }
}
