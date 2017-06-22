package com.readmunity.mapper;

import com.readmunity.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by Henry on 17/6/12.
 */
@Component(value = "userMapper")
public interface UserMapper extends BaseMapper<User> {
    void insert(User user);
    User findUserByUserInfo(String username,String email,String validateCode);
    User getUserByUsername(String username);
    User getUserById(String id);
    User getUserByEmail(String email);
    void updateByName(User user);
    void updateUserByEmail(User user);
}
