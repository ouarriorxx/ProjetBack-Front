package com.example.demo_ferme_plant.services;

import com.example.demo_ferme_plant.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User updateUser(Long userId, User updatedUser);

    void deleteUserById(Long id);

    User login(String email, String password);

    User getUserById(Long id);
}
