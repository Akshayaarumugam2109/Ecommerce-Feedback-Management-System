package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.User;

public interface UserService {

    User addUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    User updateUser(int id, User user);

    List<User> getUsersByRole(String role);

    User getUserByUsernameAndRole(String username, String role);
}
