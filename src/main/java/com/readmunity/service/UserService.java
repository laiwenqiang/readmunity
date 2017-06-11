package com.readmunity.service;

import com.readmunity.entity.User;

/**
 * Created by laiwenqiang on 2017/5/29.
 */
public interface UserService {
    User getUserById(String id);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    void save(String username, String email, String password);

    void passEmailActivation(String username,String email,String validateCode);

}
