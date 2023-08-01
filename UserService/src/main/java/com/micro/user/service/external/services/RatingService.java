package com.micro.user.service.external.services;

import com.micro.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name="RATING-SERVICE")
public interface RatingService {

    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRating( Rating values);



    @PutMapping("/rating/{ratingId}")
    public ResponseEntity<Rating> updateRating(@PathVariable("ratingId")String ratingId, Rating rating );

    @DeleteMapping("/Ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);


}
