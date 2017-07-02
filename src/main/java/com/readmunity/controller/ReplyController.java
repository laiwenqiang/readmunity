package com.readmunity.controller;

import com.readmunity.entity.Question;
import com.readmunity.entity.Reply;
import com.readmunity.service.QuestionService;
import com.readmunity.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/28.
 */
@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    QuestionService questionService;

    @Autowired
    ReplyService replyService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getReplyByQuestion(ModelMap map) {
        Question question = questionService.getQuestionById("1");
        List<Reply> replyList = replyService.getListByQuestionId("1");
        map.addAttribute("question", question);
        map.addAttribute("replylist", replyList);
        return "replylist";
    }
}
