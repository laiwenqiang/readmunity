package com.readmunity.dao.impl;

import com.readmunity.dao.UserDao;
import com.readmunity.entity.User;
import com.readmunity.mapper.BaseMapper;
import com.readmunity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Henry on 17/6/12.
 */
@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    BaseMapper mapper() {
        return userMapper;
    }
}
