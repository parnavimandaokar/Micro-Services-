package com.micro.user.service.services;

import com.micro.user.service.entities.User;

import java.util.List;


public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    //delete and update user

    User updateUser(User user);

    public void deleteUser(String userId);


}
