package com.readmunity.service;

import com.readmunity.entity.Question;

import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/27.
 */
public interface QuestionService {
    List<Question> getQuestionListByBookId(String id);
}
