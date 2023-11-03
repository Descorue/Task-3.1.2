package com.example.user_spring_boot.service;

import com.example.user_spring_boot.model.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    User findUserById(int id);

    void deleteUserById(int id);
    void updateUser(User user);

    void add(User user);
}
