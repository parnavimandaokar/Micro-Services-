package com.micro.user.service.exceptions;

import com.micro.user.service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){

        String message=ex.getMessage();
        ApiResponse response=  ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
        return  new ResponseEntity<>(response,HttpStatus.NOT_FOUND);


    }
}
