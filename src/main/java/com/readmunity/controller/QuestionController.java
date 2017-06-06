package com.readmunity.controller;

import com.readmunity.service.impl.QuestionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by laiwenqiang on 2017/5/27.
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getQuestionListByBookId(ModelMap map, @RequestParam String bookId) {
        map.addAttribute("questionlist", new QuestionServiceImpl().getQuestionListByBookId("01"));
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
}
