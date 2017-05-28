package com.readmunity.controller;

import com.readmunity.entity.Question;
import com.readmunity.entity.Reply;
import com.readmunity.service.impl.QuestionServiceImpl;
import com.readmunity.service.impl.ReplyServiceImpl;
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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getReplyByQuestion(ModelMap map) {
        Question question = new QuestionServiceImpl().getQuestionById("001");
        List<Reply> replyList = new ReplyServiceImpl().getReplayListByQuestionId("001");
        map.addAttribute("question", question);
        map.addAttribute("replylist", replyList);
        return "replaylist";
    }
}
