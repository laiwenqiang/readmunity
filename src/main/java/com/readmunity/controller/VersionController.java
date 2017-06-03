package com.readmunity.controller;

import com.readmunity.entity.Message;
import com.readmunity.service.impl.QuestionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Request;

import java.nio.channels.FileChannel;


/**
 * Created by laiwenqiang on 2017/6/1.
 *
 * 数据的版本控制，patch数据为unified。
 *
 * 用于：
 * 1. 提问&回答的数据被修改后，数据保存
 * 2. 提问&回答的数据被修改的历史记录，数据展示
 */
@Controller
@RequestMapping("/version")
public class VersionController {

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public String getQuestionByUserId(ModelMap map) {
        map.addAttribute("question", new QuestionServiceImpl().getQuestionById("01"));
        return "versionedit";
    }

    @RequestMapping(value = "/question/list", method = RequestMethod.GET)
    public String getQuestionShotList(ModelMap map) {
        map.addAttribute("shotlist", new QuestionServiceImpl().getVersionShotById("001"));
        return "versionlist";
    }

    @RequestMapping(value = "/question/patch", method = RequestMethod.GET)
    public @ResponseBody
    Message getQuestionPatch(@RequestParam("questionId") String questionId) {
        return new Message(HttpStatus.OK, new QuestionServiceImpl().getPatchById(questionId));
    }

    @RequestMapping(value = "/reply/list", method = RequestMethod.GET)
    public String getReplyList(ModelMap map) {

        return "versionlist";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody
    Message saveQuestion(@RequestParam("oldContentId") String oldContentId,
                                         @RequestParam("newContent") String newContent, @RequestParam("patch") String patch) {
        System.out.println(patch);
        return new Message(HttpStatus.OK, "success");
    }
}

