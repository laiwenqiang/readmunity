package com.readmunity.service.impl;

import com.readmunity.entity.Reply;
import com.readmunity.service.ReplyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/28.
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Override
    public List<Reply> getListByQuestionId(String id) {
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

    public List<Reply> getVersionShotById(String id) {
        List<Reply> replyList = new ArrayList<>();

        Reply reply = new Reply();
        reply.setId("001");
        reply.setVersion(0);
        reply.setSummary("创建回答");

        Reply reply2 = new Reply();
        reply2.setId("002");
        reply2.setVersion(1);
        reply2.setSummary("修复问题");

        Reply reply3 = new Reply();
        reply3.setId("003");
        reply3.setVersion(2);
        reply3.setSummary("修改样式");

        replyList.add(reply);
        replyList.add(reply2);
        replyList.add(reply3);

        return replyList;

    }

    public String getPatchById(String id) {
        String patch = "Index: filename\n"
                + "===================================================================\n"
                + "--- reply	left\n"
                + "+++ reply2	right\n"
                + "@@ -1,1 +1,1 @@\n"
                + "-" + id + "\n"
                + "-hi i\'am ok\n"
                + "-hello world\n"
                + "+hi i\' not ok\n"
                + "+\n"
                + "+hello";
        return patch;
    }
}
