package com.readmunity.service.impl;

import com.readmunity.entity.User;
import com.readmunity.service.UserService;
import com.readmunity.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/5/29.
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(String id) {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        User user = session.selectOne("entity.User.selectUserById", id);
        session.close();
        return user;
    }

    @Override
    public User getUserByName(String name) {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        User user = session.selectOne("entity.User.selectUserByName", name);
        session.close();
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        User user = session.selectOne("entity.User.selectUserByEmail", email);
        session.close();
        return user;
    }

    @Override
    public void save(String name, String email, String password) {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("email", email);
        params.put("password", password);
        session.insert("entity.User.insertUser", params);
        session.commit();
        session.close();
    }
}
