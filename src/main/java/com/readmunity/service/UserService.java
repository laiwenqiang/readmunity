package com.readmunity.service;

import com.readmunity.entity.User;

/**
 * Created by laiwenqiang on 2017/5/29.
 */
public interface UserService {
    User getUserById(String id);

    User getUserByName(String name);

    User getUserByEmail(String email);

    void save(String name, String email, String password);
}
