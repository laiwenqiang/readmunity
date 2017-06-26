package com.readmunity.dao;

import com.readmunity.entity.Book;

import java.util.List;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/6/22.
 */
public interface BookDao extends BaseDao<Book> {
    Book getBookById(String id);
    List<Book> getBookList(Map<String, String> filter);
    List<Book> getBookListLike(Map<String, String> filter);
}
