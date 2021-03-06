package com.readmunity.service.impl;

import com.readmunity.dao.QuestionDao;
import com.readmunity.dao.UserDao;
import com.readmunity.entity.Question;
import com.readmunity.service.QuestionService;
import com.readmunity.service.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/5/27.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Override
    public List<Map<String, Object>> getQuestionListByBookId(String id) {
        Map<String, String> filter = new HashMap<>();
        filter.put("bookId", id);

        List<Question> questions = questionDao.getList(filter);

        List<Map<String, Object>> result = new ArrayList<>();

        for (Question question : questions) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", question.getId());
            map.put("name", question.getName());
            if (question.getTags() != null) {
                map.put("tags", question.getTags().split(","));
            } else {
                map.put("tags", "");
            }
            map.put("createdTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(question.getCreatedTime()));
            map.put("startQty", question.getStarQty());
            result.add(map);
        }
        return result;
    }

    @Override
    public String saveQuestion(String bookId, String name, String content, String tags) {
        Map<String, String> param = new HashMap<>();
        param.put("bookId", bookId);
        param.put("name", name);
        param.put("content", content);
        param.put("tags", tags);
        param.put("createdId", Util.getCurrentId());
        param.put("createdName", Util.getCurrentName());
        questionDao.insert(param);
        return null;
    }

    @Override
    public String updateQuestion(String questionId, String content, String patch) {
        Map<String, String> param = new HashMap<>();
        param.put("content", content);
        questionDao.updateById(questionId, param);
        return null;
    }

    @Override
    public Question getQuestionById(String id) {
        return questionDao.getById("1");
    }

    public List<Question> getQuestionListByUserId(int userId) {
        return null;
    }

    public List<Question> getVersionShotById(String Id) {
        List<Question> list = new ArrayList<>();
        Question question = new Question();
        question.setId("001");
        question.setName("问题标题001");
//        question.setSummary("创建问题");
        question.setVersion(0);

        Question question2 = new Question();
        question2.setId("002");
        question2.setName("问题标题002");
//        question2.setSummary("修改内容，不规范");
        question2.setVersion(1);

        Question question3 = new Question();
        question3.setId("003");
        question3.setName("问题标题003");
//        question3.setSummary("修改样式");
        question3.setVersion(2);

        list.add(question);
        list.add(question2);
        list.add(question3);
        return list;
    }

    public String getPatchById(String id){
        String patch = "Index: filename\n"
                + "===================================================================\n"
                + "--- filename	left\n"
                + "+++ filename	right\n"
                + "@@ -1,1 +1,1 @@\n"
                +"-" + id + "\n"
                + "-hi i\'am ok\n"
                + "-hello world\n"
                + "+hi i\' not ok\n"
                + "+\n"
                + "+hello";
        return patch;
    }

    public Object getQuestionListByBookIdAndChapter(String bookId, String chapter) {
       return null;
    }

}
