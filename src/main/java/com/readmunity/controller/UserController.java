package com.readmunity.controller;

import com.readmunity.entity.User;
import com.readmunity.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by laiwenqiang on 2017/5/29.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public String getUser(ModelMap map) {
        User user = new UserServiceImpl().getUserById("001");
        map.addAttribute("user", user);
        return "user";
    }
}
