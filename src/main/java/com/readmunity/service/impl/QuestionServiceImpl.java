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
        questionList.add(new Question("001","问题标题01", "问题内容01问题内容01问题内容01问题内容01问题内容01问题内容01" +
                "问题内容01问题内容01问题内容01问题内容01" +
                "问题内容01问题内容01问题内容01问题内容01"));
        questionList.add(new Question("002","问题标题02", "问题内容02问题内容02问题内容02问题内容02问题内容02问题内容02问题内容02" +
                "问题内容02问题内容02问题内容02问题内容02问题内容02" +
                "问题内容02问题内容02问题内容02问题内容02"));
        questionList.add(new Question("003","问题标题03", "问题内容03问题内容03问题内容03问题内容03问题内容03问题内容03问题内容03" +
                "问题内容03问题内容03问题内容03问题内容03问题内容03" +
                "问题内容03问题内容03问题内容03问题内容03"));
        questionList.add(new Question("004","问题列表04", "问题内容04问题内容04问题内容04问题内容04问题内容04问题内容04" +
                "问题内容04问题内容04问题内容04问题内容04" +
                "问题内容04问题内容04问题内容04问题内容04"));
        return questionList;
    }

    public Question getQuestionById(String id) {
        return new Question("001",
                "问题标题01",
                "# 本章节的程序将划分三块： #\n" +
                        "1. startup启动模块，只有一个类：``` BootStrap```。\n" +
                        "3. connector模块.\n" +
                        "	- <font color=red>连接器和它的支撑类``` HttpConnector ``` 和 ``` HttpProcessor  ```。</font>\n" +
                        "	- 指代 HTTP 请求的类(HttpRequest)和它的辅助类。\n" +
                        "	- 指代 HTTP 响应的类(HttpResponse)和它的辅助类。\n" +
                        "	- Facade 类(HttpRequestFacade 和 HttpResponseFacade)\n" +
                        "	- Constant 类。 \n" +
                        "3. core模块，由``` ServletProcessor ```和``` StaticResourceProcessor ```组成。\n"
        +"# 输入信息...\n" +
                        "\n" +
                        "``` java\n" +
                        "hello world\n" +
                        "```");
    }
}
