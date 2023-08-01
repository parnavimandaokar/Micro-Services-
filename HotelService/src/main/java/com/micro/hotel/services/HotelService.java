package com.micro.hotel.services;

import com.micro.hotel.entites.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel getHotel(String id);

}
