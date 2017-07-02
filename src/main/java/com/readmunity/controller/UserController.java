package com.readmunity.controller;

import com.readmunity.entity.Message;
import com.readmunity.entity.User;
import com.readmunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


/**
 * Created by laiwenqiang on 2017/5/29.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getUserById(ModelMap map, @RequestParam String id) {
        User user = null;
        if (user == null) {
            return "index";
        }
        map.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getUserByName(ModelMap map, @RequestParam String name) throws Exception {
        User user = userService.getUserByUsername(name);
        if(user == null) {
            return "index";
        }
        map.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/list/active", method = RequestMethod.GET)
    public String getActiveUserList(ModelMap map) {
        List<User> users = userService.getActiveUserList();
        map.addAttribute("amount", users.size());
        map.addAttribute("userList", users);
        return "userlist";
    }

    @RequestMapping(value = "/list/filter", method = RequestMethod.GET)
    public String getUserList(ModelMap map, @RequestParam Map<String, String> filter) {
        List<User> users = userService.getUserList(filter);
        map.addAttribute("amount", users.size());
        map.addAttribute("userList", users);
        return "fragments/userlist :: resultlist";
    }

    @RequestMapping(value = "/setting/current", method = RequestMethod.GET)
    public String getLogin(ModelMap map) throws Exception {
        User user = userService.setting();
        map.addAttribute("user", user);
        return "usersetting";
    }

    @RequestMapping(value = "/profile/save", method = RequestMethod.POST)
    public String saveProfile(@RequestParam Map<String, String> setParam, ModelMap map) {
        formatParam(setParam);
        User user = userService.updateCurrent(setParam);
        map.addAttribute("user", user);
        return "usersetting";
    }

    @RequestMapping(value = "/avatar/upload", method = RequestMethod.POST)
    public @ResponseBody
    Message uploadAvatar(@RequestParam MultipartFile avatar) {
        return userService.uploadAvatar(avatar);
    }

    @RequestMapping(value = "/avatar/crop", method = RequestMethod.POST)
    public String cropAvatar(@RequestParam String path, @RequestParam String x, @RequestParam String y, @RequestParam String w,
                             @RequestParam String h, ModelMap map) {
        User user = userService.cropAvatar(path, Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(w), Integer.parseInt(h));
        map.addAttribute("user", user);
        return "usersetting";
    }

    @RequestMapping(value = "/avatar", method = RequestMethod.GET)
    public @ResponseBody
    Message getCurrentAvatar() {
       return userService.getCurrentAvatar();
    }

    public void formatParam(Map<String, String> param) {
        param.remove("_csrf");
    }



}
