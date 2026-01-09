package com.kata.springmvc.dao;

import com.kata.springmvc.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();
    public User findById(Long id);
    public void save(User user);
    public void delete(Long id);
}
