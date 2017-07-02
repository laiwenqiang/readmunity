package com.readmunity.dao.impl;

import com.readmunity.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by laiwenqiang on 2017/6/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void getById() {
        userDao.getById("1");
    }

    @Test
    public void insertTest() {
        Map<String, String> param = new HashMap<>();
        param.put("username", "Tom");
        param.put("password", "Tom  password");
        param.put("email", "tom@gmail.com");
        userDao.insert(param);
    }

    @Test
    public void updateTest() {
        Map<String, String> setParam = new HashMap<>();
        setParam.put("email", "update@gmail.com");

        Map<String, String> filterParam = new HashMap<>();
        filterParam.put("username", "admin");

        userDao.update(setParam, filterParam);
    }
}
