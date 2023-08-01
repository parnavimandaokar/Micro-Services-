package com.micro.hotel.impl;

import com.micro.hotel.entites.Hotel;
import com.micro.hotel.exceptions.ResourceNotFoundException;
import com.micro.hotel.repositories.HotelRepository;
import com.micro.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceimpl implements HotelService {


    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
       String hotelId= UUID.randomUUID().toString();
       hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found"));
    }
}
