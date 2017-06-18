package com.readmunity.controller;

import com.readmunity.entity.Message;
import com.readmunity.entity.User;
import com.readmunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zhaolaing on 2017/5/27.
 */
@Controller
@RequestMapping("/sign")
public class SignUpController {

    @Autowired
    private UserService userService;

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
    public String join(Model model, @RequestParam String username, @RequestParam String email, @RequestParam String password) {
        userService.save(username, email, password);
        return "signUpToEmail";
    }

    @RequestMapping(value = "/validate/username", method = RequestMethod.GET)
    public @ResponseBody
    Message validateName(@RequestParam("username") String username) {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return new Message(HttpStatus.OK, "success");
        } else {
            return new Message(HttpStatus.OK, "failure");
        }
    }

    @RequestMapping(value = "/validate/email", method = RequestMethod.GET)
    public @ResponseBody
    Message validateEmail(@RequestParam("email") String email) {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            return new Message(HttpStatus.OK, "success");
        } else {
            return new Message(HttpStatus.OK, "failure");
        }
    }

    /**
     * 用于邮件验证邮箱
     *
     * @param username
     * @param email
     * @param validateCode
     * @return
     */
    @RequestMapping(value = "emailActivation", method = {RequestMethod.GET, RequestMethod.POST})
    public String emailActivation(Model model, @RequestParam String username, @RequestParam String email, @RequestParam String validateCode) {
        model.addAttribute("message", null);
        try {
            userService.passEmailActivation(username, email, validateCode);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        return "activate";
    }

    /**
     * 用于跳转输入邮件地址
     *
     * @return
     */
    @RequestMapping(value = "/password_reset", method = {RequestMethod.GET, RequestMethod.POST})
    public String passwordReset(String toEmail, Model model) {
        if (toEmail == null || "".equals(toEmail)) return "password_reset";
        try {
            userService.passwordResetPassEmail(toEmail);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }
        if (model.containsAttribute("message"))
            return "password_reset";
        return "password_reset_success";
    }

    /**
     * 实现动态地址。需要解密用户名和用户修改时间，还有用户的验证码。
     * @param info
     * @return
     */
    @RequestMapping(value = "/password_reset/{info}", method = {RequestMethod.GET, RequestMethod.POST})
    public String passwordResetInfo(@PathVariable String info) {
        System.out.print(info);

        return "password_reset_now";
    }

}
