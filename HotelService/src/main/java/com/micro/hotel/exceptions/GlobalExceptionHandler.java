package com.micro.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {

    public ResponseEntity<Map<String,Object>> notFoundHandler(ResourceNotFoundException ex){
    Map map=new HashMap();
    map.put("message",ex.getMessage());
    map.put("success",false);
    map.put("status", HttpStatus.NOT_FOUND);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
