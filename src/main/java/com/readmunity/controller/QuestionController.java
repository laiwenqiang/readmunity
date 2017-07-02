package com.readmunity.controller;

import com.readmunity.entity.Message;
import com.readmunity.service.QuestionService;
import com.readmunity.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Stack;

/**
 * Created by laiwenqiang on 2017/5/27.
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getQuestionListByBookId(ModelMap map, @RequestParam String bookId) {
        map.addAttribute("questionlist", questionService.getQuestionListByBookId("1"));
        map.addAttribute("bookId", bookId);
        return "questionlist";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getQuestionById(ModelMap map) {
        map.addAttribute("question", new QuestionServiceImpl().getQuestionById("01"));
        return "question";
    }

    @RequestMapping(value = "/chapter/list", method = RequestMethod.GET)
    public String getQuestionListByBookIdAndChapter(ModelMap map, @RequestParam String bookId,
                                                    @RequestParam String chapter) {
        map.addAttribute("questionlist", new QuestionServiceImpl().getQuestionListByBookIdAndChapter(bookId, chapter));
        map.addAttribute("bookId", bookId);
        return "questionlist";
    }

    @RequestMapping(value = "/ask", method = RequestMethod.GET)
    public String askQuestion(ModelMap map, @RequestParam String bookId) {
        map.addAttribute("bookId", bookId);
        return "questionask";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody
    Message saveQuestion(@RequestParam String bookId, @RequestParam String name,
                         @RequestParam String content, @RequestParam String tags) {
        questionService.saveQuestion(bookId, name, content, tags);

        return new Message(HttpStatus.OK, "success");
    }

}
