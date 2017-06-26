package com.readmunity.dao;

import com.readmunity.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Henry on 17/6/11.
 */
public interface UserDao extends BaseDao<User> {
    User getUserById(String id);
    User getOne(Map<String, String> filter);
    List<User> getUserList(Map<String, String> filter);
    List<User> getUserListLike(Map<String, String> filter);
    void updateById(String id, Map<String, String> setParam);
    void update(Map<String, String> setParam, Map<String, String> filterParam);
    void insert(Map<String, String> param);
}
