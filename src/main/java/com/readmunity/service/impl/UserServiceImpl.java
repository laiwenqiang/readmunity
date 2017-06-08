package com.readmunity.service.impl;

import com.readmunity.entity.Book;
import com.readmunity.entity.Question;
import com.readmunity.entity.Reply;
import com.readmunity.entity.User;
import com.readmunity.service.UserService;
import com.readmunity.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/29.
 */
public class UserServiceImpl implements UserService {

    public User getUserById(String id) {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        User user = session.selectOne("entity.User.selectUser", id);
        session.close();
        return user;
    }

}
