package com.readmunity.dao.impl;

import com.readmunity.dao.UserDao;
import com.readmunity.entity.User;
import com.readmunity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Henry on 17/6/12.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String id) {
        return super.getById(id, userMapper);
    }

    @Override
    public User getOne(Map<String, String> filter) {
        return super.getOne(filter, userMapper);
    }

    @Override
    public List<User> getUserList(Map<String, String> filter) {
        return super.getList(filter, userMapper);
    }

    @Override
    public List<User> getUserListLike(Map<String, String> filter) {
        return super.getListLike(filter, userMapper);
    }

    @Override
    public void updateById(String id, Map<String, String> setParam) {
        super.updateById(id, setParam, userMapper);
    }

    @Override
    public void update(Map<String, String> setParam, Map<String, String> filterParam) {
       super.update(setParam, filterParam, userMapper);
    }

    @Override
    public void insert(Map<String, String> param) {
        super.insert(param, userMapper);
    }


}
