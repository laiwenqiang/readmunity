package com.readmunity.service.impl;

import com.readmunity.dao.UserDao;
import com.readmunity.entity.User;
import com.readmunity.service.UserService;
import com.readmunity.util.Config;
import com.readmunity.util.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by laiwenqiang on 2017/5/29.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private SendEmail sendEmail;

    @Override
    public User getUserById(String id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public void save(String username, String email, String password) {
        User user=new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setValidateCode(Config.getRandom());
        userDao.insert(user);
        sendEmail.signUpToEmail(username,email,user.getValidateCode());
    }

    @Override
    public void passEmailActivation(String username, String email, String validateCode) {

    }
}
