package com.kata.springmvc.dao;

import com.kata.springmvc.model.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();

    User findById(Long id);

    /**
     * Persist a new user.
     */
    void create(User user);

    /**
     * Update an existing user.
     */
    void update(User user);

    /**
     * Delete a user by id (implementation is responsible for loading the entity and removing it).
     */
    void deleteById(Long id);
}
