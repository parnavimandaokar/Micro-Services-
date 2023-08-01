package com.micro.rating.repository;

import com.micro.rating.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,String> {

    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);

}
