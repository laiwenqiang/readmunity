package com.readmunity.dao;

import com.readmunity.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Henry on 17/6/11.
 */
public interface UserDao {
    User getUserById(String id);
    void insert(User user);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    List<User> getUserList(Map<String, String> filter);
    User updateUserByName(String name, User user);
    void updateUserByEmail(User user);
}
