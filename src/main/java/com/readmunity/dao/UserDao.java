package com.readmunity.dao;

import com.readmunity.entity.User;

import java.util.List;

/**
 * Created by Henry on 17/6/11.
 */
public interface UserDao extends BaseDao<User> {
    List<User> selectActiveUser();
}
