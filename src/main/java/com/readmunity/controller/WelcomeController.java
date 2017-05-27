package com.readmunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhaolaing on 2017/5/27.
 */
@Controller
@RequestMapping("/")
public class WelcomeController {

    @RequestMapping("/")
    public String getList(ModelMap map) {
        return "welcome";
    }

}
