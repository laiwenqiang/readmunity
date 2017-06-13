package com.readmunity.controller;

import com.readmunity.entity.Message;
import com.readmunity.entity.User;
import com.readmunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;


/**
 * Created by laiwenqiang on 2017/5/29.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getUser(ModelMap map, @RequestParam String id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return "index";
        }
        map.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getUserByName(ModelMap map, @RequestParam String name) {
        User user = userService.getUserByUsername(name);
        if(user == null) {
            return "index";
        }
        map.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/setting/current", method = RequestMethod.GET)
    public String setCurrent(ModelMap map) {
        User user = userService.getUserByCurrentUserName();
        map.addAttribute("user", user);
        return "usersetting";
    }

    @RequestMapping(value = "/save/profile", method = RequestMethod.POST)
    public String saveProfile(@ModelAttribute User user, ModelMap map) {
        user = userService.updateProfileByCurrentName(user);
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



}
