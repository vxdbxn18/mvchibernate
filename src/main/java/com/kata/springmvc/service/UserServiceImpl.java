package com.kata.springmvc.service;

import com.kata.springmvc.dao.UserDAO;
import com.kata.springmvc.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserDAO userDAO;

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
    public void save(User user) {
        userDAO.save(user);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDAO.delete(id);
    }
}
