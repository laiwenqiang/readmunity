package com.readmunity.controller;

import com.readmunity.entity.Question;
import com.readmunity.service.impl.QuestionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/27.
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getQuestionListByBookId(ModelMap map) {
        map.addAttribute("questionlist", new QuestionServiceImpl().getQuestionListByBookId("01"));
        return "questionlist";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getQuestionById(ModelMap map) {
        map.addAttribute("question", new QuestionServiceImpl().getQuestionById("01"));
        return "question";
    }
}
