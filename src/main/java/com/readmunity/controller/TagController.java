package com.readmunity.controller;

import com.readmunity.entity.Tag;
import com.readmunity.service.impl.TagServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by laiwenqiang on 2017/6/7.
 */
@Controller
@RequestMapping("/tag")
public class TagController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<String> getTagsList(@RequestParam String query) {
        return new TagServiceImpl().getTagNameList(query);
    }
}
