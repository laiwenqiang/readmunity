package com.readmunity.service.impl;

import com.readmunity.entity.Question;
import com.readmunity.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/27.
 */
public class QuestionServiceImpl implements QuestionService {

    public List<Question> getQuestionListByBookId(String id) {
        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question("问题标题01", "001", 0, "问题内容01", 100, 20, "001", "001",
                        "赖文强", "2017年06月02日07:02:24"));
        questionList.add(new Question("问题标题01", "001", 0, "问题内容01", 100, 20, "001", "001",
                "赖文强", "2017年06月02日07:02:24"));
        questionList.add(new Question("问题标题01", "001", 0, "问题内容01", 100, 20, "001", "001",
                "赖文强", "2017年06月02日07:02:24"));
        questionList.add(new Question("问题标题01", "001", 0, "问题内容01", 100, 20, "001", "001",
                "赖文强", "2017年06月02日07:02:24"));
        questionList.add(new Question("问题标题01", "001", 0, "问题内容01", 100, 20, "001", "001",
                "赖文强", "2017年06月02日07:02:24"));
        return questionList;
    }

    public Question getQuestionById(String id) {
        return new Question("问题标题01", "001", 0, "# 本章节的程序将划分三块： #\n" +
                "1. startup启动模块，只有一个类：``` BootStrap```。\n" +
                "3. connector模块.\n" +
                "	- <font color=red>连接器和它的支撑类``` HttpConnector ``` 和 ``` HttpProcessor  ```。</font>\n" +
                "	- 指代 HTTP 请求的类(HttpRequest)和它的辅助类。\n" +
                "	- 指代 HTTP 响应的类(HttpResponse)和它的辅助类。\n" +
                "	- Facade 类(HttpRequestFacade 和 HttpResponseFacade)\n" +
                "	- Constant 类。 \n" +
                "3. core模块，由``` ServletProcessor ```和``` StaticResourceProcessor ```组成。\n" +
                "# 输入信息...\n" +
                "\n" +
                "``` java\n" +
                "hello world\n" +
                "```", 100, 20, "001", "001",
                "赖文强", "2017年06月02日07:02:24");
    }

    public List<Question> getQuestionListByUserId(String userId) {
        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question("问题标题01", "001", 0, "问题内容01", 100, 20, "001", "001",
                        "赖文强", "2017年06月02日07:02:24"));
        questionList.add(new Question("问题标题01", "001", 0, "问题内容01", 100, 20, "001", "001",
                "赖文强", "2017年06月02日07:02:24"));
        questionList.add(new Question("问题标题01", "001", 0, "问题内容01", 100, 20, "001", "001",
                "赖文强", "2017年06月02日07:02:24"));
        questionList.add(new Question("问题标题01", "001", 0, "问题内容01", 100, 20, "001", "001",
                "赖文强", "2017年06月02日07:02:24"));
        questionList.add(new Question("问题标题01", "001", 0, "问题内容01", 100, 20, "001", "001",
                "赖文强", "2017年06月02日07:02:24"));
        return questionList;
    }
}
