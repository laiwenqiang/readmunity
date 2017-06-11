package com.readmunity.mapper;

import com.readmunity.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Henry on 17/6/12.
 */
@Mapper
@Component(value = "userMapper")
public interface UserMapper {
    public void insert(User user);
    public User findUserByUserInfo(String username,String email,String validateCode);
    public User getUserById(String id);
    public User getUserByUsername(String username);
    public User getUserByEmail(String email);
}
