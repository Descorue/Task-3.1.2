package com.example.user_spring_boot.UserDao;



import com.example.user_spring_boot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User findUserById(int id);

    void add(User user);

    void deleteUserById(int id);

    void updateUser(User user);


}
