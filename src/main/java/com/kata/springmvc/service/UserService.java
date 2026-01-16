package com.kata.springmvc.service;

import com.kata.springmvc.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    void create(String name, String email, Integer age);

    void update(Long id, String name, String email, Integer age);

    void deleteById(Long id);
}
