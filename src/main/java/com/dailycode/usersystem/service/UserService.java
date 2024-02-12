package com.dailycode.usersystem.service;

import com.dailycode.usersystem.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();
}
