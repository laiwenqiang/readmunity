package com.readmunity.controller;

import com.readmunity.service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zhaolaing on 2017/5/27.
 */
@Controller
@RequestMapping("/sign")
public class SignUpController {

    @RequestMapping(value = "signUp", method = RequestMethod.GET)
    public String getList(ModelMap map) {
        return "signUp";
    }

}
