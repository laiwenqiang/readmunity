package com.readmunity.dao.impl;

import com.readmunity.dao.BookDao;
import com.readmunity.entity.Book;
import com.readmunity.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/6/22.
 */
@Repository
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getBookList(Map<String, String> filter) {
        return super.getList(filter, bookMapper);
    }
}
