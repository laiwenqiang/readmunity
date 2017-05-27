package com.readmunity.controller;

import com.readmunity.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private WelcomeService welcomeService;
    @RequestMapping("/")
    public String getList(ModelMap map) {
        map.addAttribute("hotBooks", welcomeService.gethotBooks());
        map.addAttribute("goodBooksFromClassification", welcomeService.getGoodBooksFromClassification());
        map.addAttribute("rankingBook",welcomeService.getRankingBook());
        return "welcome";
    }

}
