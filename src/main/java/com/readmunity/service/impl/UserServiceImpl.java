package com.readmunity.service.impl;

import com.readmunity.entity.Book;
import com.readmunity.entity.Question;
import com.readmunity.entity.Reply;
import com.readmunity.entity.User;

import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/29.
 */
public class UserServiceImpl {

    public User getUserById(String id) {
        List<Book> starBook = new BookServiceImpl().getStarBookListByUserId("001");
        List<Question> questionList = new QuestionServiceImpl().getQuestionListByUserId("001");
        List<Reply> replyList = new ReplyServiceImpl().getReplyListByUserId("001");
        User user = new User("001", "用户名字", "beijin", "1260091093@qq.com",
                "1260091093@qq", "weibo", "githubAddress", "twitter",
                987, "满级战士", starBook, questionList, replyList);
        return user;
    }
}
