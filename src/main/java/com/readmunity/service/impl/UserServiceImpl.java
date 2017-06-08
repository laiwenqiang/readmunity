package com.readmunity.service.impl;

import com.readmunity.entity.User;
import com.readmunity.service.UserService;
import com.readmunity.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by laiwenqiang on 2017/5/29.
 */
public class UserServiceImpl implements UserService {

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

}
