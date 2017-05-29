package com.readmunity.service.impl;

import com.readmunity.entity.Reply;
import com.readmunity.service.ReplyService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/28.
 */
public class ReplyServiceImpl implements ReplyService {

    public List<Reply> getReplyListByQuestionId(String id) {
        List<Reply> replyList = new ArrayList<>();
        replyList.add(new Reply("回答ID——001", "问题ID-001", "问题标题-001","提问者ID-001", "# 回答内容-001 \n ``` java public \n ```", "回答者ID-001", "回答者姓名-001",
                200));
        replyList.add(new Reply("回答ID——002", "问题ID-001", "问题标题-001","提问者ID-001", "```Question question = new QuestionServiceImpl().getQuestionById(\"001\");```", "回答者ID-002", "回答者姓名-002",
                100));
        replyList.add(new Reply("回答ID——003", "问题ID-001", "问题标题-001","提问者ID-001", "### 回答内容-003", "回答者ID-003", "回答者姓名-003",
                50));
        replyList.add(new Reply("回答ID——004", "问题ID-001", "问题标题-001","提问者ID-001", "#### 回答内容-004", "回答者ID-004", "回答者姓名-004",
                10));

        return replyList;
    }


    public List<Reply> getReplyListByUserId(String userId) {
        List<Reply> replyList = new ArrayList<>();
        replyList.add(new Reply("回答ID——001", "问题ID-001", "问题标题-001","提问者ID-001", "# 回答内容-001 \n ``` java public \n ```", "回答者ID-001", "回答者姓名-001",
                200));
        replyList.add(new Reply("回答ID——002", "问题ID-002", "问题标题-002","提问者ID-001", "```Question question = new QuestionServiceImpl().getQuestionById(\"001\");```", "回答者ID-002", "回答者姓名-002",
                100));
        replyList.add(new Reply("回答ID——003", "问题ID-003", "问题标题-003","提问者ID-001", "### 回答内容-003", "回答者ID-003", "回答者姓名-003",
                50));
        replyList.add(new Reply("回答ID——004", "问题ID-004", "问题标题-004","提问者ID-001", "#### 回答内容-004", "回答者ID-004", "回答者姓名-004",
                10));

        return replyList;
    }
}
