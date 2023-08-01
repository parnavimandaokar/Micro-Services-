package com.micro.user.service.controllers;


import com.micro.user.service.entities.User;
import com.micro.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
       User user1= userService.saveUser(user);
       return  ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    int retrycount=1;

   // @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @GetMapping("/{userId}")
   // @Retry(name="ratingHotelService",fallbackMethod ="ratingHotelService" )
    @RateLimiter(name="userRateLimiter",fallbackMethod="ratingHotelFallback")
    public  ResponseEntity<User> getSingleUser(@PathVariable String userId){
        logger.info("Retry count {}",retrycount);
        retrycount++;
        User user=  userService.getUser(userId);
      return  ResponseEntity.ok(user);
    }



    //creating fall back method for circuitbreaker
    public ResponseEntity<User>  ratingHotelFallback(String userId,Exception ex){
      // logger.info("Fallback is executed as service is  down ",ex.getMessage());

      User user= User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("this is dummy user as service is down")
                .userId("16352")
                .build();
       return  new ResponseEntity<>(user,HttpStatus.OK);



    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
     List<User> allUser =  userService.getAllUser();
     return ResponseEntity.ok(allUser);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.updateUser(user));
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId")String userId){
        this.userService.deleteUser(userId);

    }


}
