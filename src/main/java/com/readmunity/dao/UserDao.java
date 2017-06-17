package com.readmunity.dao;

import com.readmunity.entity.User;

import java.util.List;

/**
 * Created by Henry on 17/6/11.
 */
public interface UserDao {
    void insert(User user);
    User getUserById(String id);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    List<User> getUserList(String filter);
    User updateUserByName(String name, User user);
    void updateUserByEmail(User user);
}
