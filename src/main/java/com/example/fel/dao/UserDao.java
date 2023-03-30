package com.example.fel.dao;

import com.example.fel.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    User getUser(int id);
    void deleteUser(int id);
    void updateUser(User user);
    User findUserByUsername(String username);
}
