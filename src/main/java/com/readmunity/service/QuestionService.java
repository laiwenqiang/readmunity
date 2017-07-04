package com.readmunity.service;

import com.readmunity.entity.Question;

import java.util.List;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/5/27.
 */
public interface QuestionService {
    List<Map<String, Object>> getQuestionListByBookId(String id);

    Question getQuestionById(String id);

    String saveQuestion(String bookId, String name, String content, String tags);

    String updateQuestion(String questionId, String content, String patch);
}
