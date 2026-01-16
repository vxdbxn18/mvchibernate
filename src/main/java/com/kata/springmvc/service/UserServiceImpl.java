package com.kata.springmvc.service;

import com.kata.springmvc.dao.UserDAO;
import com.kata.springmvc.exception.UserNotFoundException;
import com.kata.springmvc.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;

    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public User findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    @Transactional
    public void create(String name, String email, Integer age) {
        User user = new User();
        applyFields(user, name, email, age);
        userDAO.create(user);
    }

    @Override
    @Transactional
    public void update(Long id, String name, String email, Integer age) {
        User user = userDAO.findById(id);
        if (user == null) {
            throw new UserNotFoundException("User with id %d not found".formatted(id));
        }
        applyFields(user, name, email, age);
        userDAO.update(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }

    private void applyFields(User user, String name, String email, Integer age) {
        user.setName(name);
        user.setEmail(email);
        user.setAge(age);
    }
}
