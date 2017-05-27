package com.readmunity.service.impl;

import com.readmunity.entity.Question;
import com.readmunity.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/27.
 */
public class QuestionServiceImpl implements QuestionService {

    public List<Question> getQuestionListById(String id) {
        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question("问题标题01", "问题内容01问题内容01问题内容01问题内容01问题内容01问题内容01" +
                "问题内容01问题内容01问题内容01问题内容01" +
                "问题内容01问题内容01问题内容01问题内容01"));
        questionList.add(new Question("问题标题02", "问题内容02问题内容02问题内容02问题内容02问题内容02问题内容02问题内容02" +
                "问题内容02问题内容02问题内容02问题内容02问题内容02" +
                "问题内容02问题内容02问题内容02问题内容02"));
        questionList.add(new Question("问题标题03", "问题内容03问题内容03问题内容03问题内容03问题内容03问题内容03问题内容03" +
                "问题内容03问题内容03问题内容03问题内容03问题内容03" +
                "问题内容03问题内容03问题内容03问题内容03"));
        questionList.add(new Question("问题列表04", "问题内容04问题内容04问题内容04问题内容04问题内容04问题内容04" +
                "问题内容04问题内容04问题内容04问题内容04" +
                "问题内容04问题内容04问题内容04问题内容04"));
        return questionList;
    }
}
