package com.readmunity.dao;

import com.readmunity.entity.User;

/**
 * Created by Henry on 17/6/11.
 */
public interface UserDao {
    public void insert(User user);
    public User getUserById(String id);
    public User getUserByUsername(String username);
    public User getUserByEmail(String email);
    User updateUserByName(String name, User user);

}
