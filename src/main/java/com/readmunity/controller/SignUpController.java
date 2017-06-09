package com.readmunity.controller;

import com.readmunity.entity.Message;
import com.readmunity.entity.User;
import com.readmunity.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhaolaing on 2017/5/27.
 */
@Controller
@RequestMapping("/sign")
public class SignUpController {

    @RequestMapping(value = "signUp", method = RequestMethod.GET)
    public String getSignUp(ModelMap map) {
        return "signUp";
    }

    @RequestMapping(value = "signIn", method = RequestMethod.GET)
    public String getSignIn(ModelMap map) {
        return "signIn";
    }
    @RequestMapping("/signIn-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "signIn";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(Model model, @RequestParam String name, @RequestParam String email, @RequestParam String password) {
        new UserServiceImpl().save(name, email, password);
        return "signIn";
    }

    @RequestMapping(value = "/validate/name", method = RequestMethod.GET)
    public @ResponseBody
    Message validateName(@RequestParam("name") String name) {
        User user = new UserServiceImpl().getUserByName(name);
        if (user == null) {
            return new Message(HttpStatus.OK, "success");
        } else {
            return new Message(HttpStatus.OK, "failure");
        }
    }

    @RequestMapping(value = "/validate/email", method = RequestMethod.GET)
    public @ResponseBody
    Message validateEmail(@RequestParam("email") String email) {
        User user = new UserServiceImpl().getUserByEmail(email);
        if (user == null) {
            return new Message(HttpStatus.OK, "success");
        } else {
            return new Message(HttpStatus.OK, "failure");
        }
    }


}
