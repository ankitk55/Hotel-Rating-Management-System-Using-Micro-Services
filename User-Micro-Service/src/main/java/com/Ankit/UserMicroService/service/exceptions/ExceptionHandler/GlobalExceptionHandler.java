package com.Ankit.UserMicroService.service.exceptions.ExceptionHandler;

import com.Ankit.UserMicroService.service.exceptions.userNotFoundException;
import com.Ankit.UserMicroService.service.payLoad.apiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
   @org.springframework.web.bind.annotation.ExceptionHandler(userNotFoundException.class)
    public ResponseEntity<apiResponse>userNotFound(userNotFoundException ex){
       String ms =ex.getMessage();
       apiResponse ap = apiResponse.builder().message(ms).status(true).httpStatus(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(ap,HttpStatus.NOT_FOUND);
    }
}
