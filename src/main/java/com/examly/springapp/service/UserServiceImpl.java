package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User updateUser(int id, User user) {
        User existing = userRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setUsername(user.getUsername());
            existing.setEmail(user.getEmail());
            existing.setRole(user.getRole());
            return userRepo.save(existing);
        }
        return null;
    }

    @Override
    public List<User> getUsersByRole(String role) {
        return userRepo.findByRole(role);
    }

    @Override
    public User getUserByUsernameAndRole(String username, String role) {
        return userRepo.findByUsernameAndRole(username, role);
    }
}
