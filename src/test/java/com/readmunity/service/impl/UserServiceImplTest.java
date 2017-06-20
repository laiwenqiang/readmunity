package com.readmunity.service.impl;

import com.readmunity.entity.User;
import com.readmunity.service.UserService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by laiwenqiang on 2017/6/8.
 */
public class UserServiceImplTest {

    private UserService userService = new UserServiceImpl();
    @Test
    public void testGetUserById() {
       // User user = userService.getUserById("1");
       // assertEquals(new Integer(1), user.getId());
    }
}
