package com.kata.springmvc.service;

import com.kata.springmvc.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    void create(User userData);

    void update(User userData);

    void deleteById(Long id);
}
