package com.readmunity.dao.impl;

import com.readmunity.dao.UserDao;
import com.readmunity.entity.User;
import com.readmunity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Henry on 17/6/12.
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    @Override
    public User updateUserByName(String name, User user) {
        user.setUsername(name);
        userMapper.updateByName(user);
        return user;
    }
}
