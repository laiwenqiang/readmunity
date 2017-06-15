package com.readmunity.mapper;

import com.readmunity.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Henry on 17/6/12.
 */
@Component(value = "userMapper")
public interface UserMapper {
    void insert(User user);
    User findUserByUserInfo(String username,String email,String validateCode);
    User getUserById(String id);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    List<User> getUserList();
    void updateByName(User user);
    void updateUserByEmail(User user);
}
