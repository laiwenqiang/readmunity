package com.readmunity.controller;

import com.readmunity.service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by laiwenqiang on 2017/5/26.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String getList(ModelMap map) {
        map.addAttribute("message", new BookServiceImpl().getList());
        return "index";
    }

}
