package com.readmunity.service;

import com.readmunity.entity.Reply;

import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/28.
 */
public interface ReplyService {

    List<Reply> getListByQuestionId(String questionId);
}
