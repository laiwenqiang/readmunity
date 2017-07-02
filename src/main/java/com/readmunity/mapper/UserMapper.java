package com.readmunity.mapper;

import com.readmunity.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Henry on 17/6/12.
 */
@Component(value = "userMapper")
public interface UserMapper extends BaseMapper<User> {
    void updateByName(User user);
    void updateUserByEmail(User user);

    List<User> selectActiveUser();
}
