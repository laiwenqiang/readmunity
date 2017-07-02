package com.readmunity.service;

import com.readmunity.entity.Book;

import java.util.List;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/5/26.
 */
public interface BookService {
    Book getBookById(String id);
    List<Book> getBookList(Map<String, String> filter);
    List<Book> getBookListLike(Map<String, String> filter);
}
