package com.micro.user.service;

import com.micro.user.service.entities.Rating;
import com.micro.user.service.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

	/*@Test
	void createRating(){
		Rating rating = Rating.builder().rating("10").userId("").hotelId("").feedback("this is created using feign client").build();
		Rating savedRating =ratingService.createRating(rating);

		System.out.println("new rating created");

	}*/
/*
	@Test
	void createRating(){
		Rating rating = Rating.builder().rating("10").userId("").hotelId("").feedback("this is created using feign client").build();
		ResponseEntity<Rating> ratingResponseEntity =ratingService.createRating(rating);

		System.out.println("new rating created");

	}*/

}
