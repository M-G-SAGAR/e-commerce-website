package com.user.services;

import java.util.List;

import com.user.entities.User;

public interface UserService {

    // Create User
    User create(User user);

    // Get All Users
    List<User> getUsers();

    // Get User By Id
    User getUserById(String userId);

    // Update User
    User update(User user, String userId);

    // Delete User By Id
    void deleteUser(String userId);
}

