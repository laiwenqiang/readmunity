package com.readmunity.service.impl;

import com.readmunity.entity.Book;
import com.readmunity.entity.Question;
import com.readmunity.entity.Reply;
import com.readmunity.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/29.
 */
public class UserServiceImpl {

    public User getUserById(String id) {
        List<Book> starBook = new BookServiceImpl().getStarBookListByUserId(1);
        List<Question> questionList = new QuestionServiceImpl().getQuestionListByUserId(1);
        List<Reply> replyList = new ReplyServiceImpl().getReplyListByUserId("001");
        User user = new User(1, "用户名字", "beijin", "1260091093@qq.com",
                "1260091093@qq", "weibo", "githubAddress", "twitter",
                987, "满级战士", starBook, questionList, replyList);

        String resource = "mybatis-config.xml";
        InputStream stream = null;
        try {
            stream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = ssf.openSession();


        User user2 = session.selectOne("entity.User.selectUser", 1);
        System.out.println(user2);

        return user;
    }
}
