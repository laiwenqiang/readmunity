package com.readmunity.dao.impl;

import com.readmunity.dao.QuestionDao;
import com.readmunity.entity.Question;
import com.readmunity.mapper.BaseMapper;
import com.readmunity.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by laiwenqiang on 2017/6/22.
 */
@Repository
public class QuestionDaoImpl extends AbstractDao<Question> implements QuestionDao{

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    BaseMapper mapper() {
        return questionMapper;
    }
}
