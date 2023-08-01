package com.micro.hotel.repositories;

import com.micro.hotel.entites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String > {
}
