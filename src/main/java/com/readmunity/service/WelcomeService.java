package com.readmunity.service;

import com.readmunity.entity.Book;

import java.util.List;
import java.util.Map;

/**
 * Created by Henry on 17/5/28.
 */
public interface WelcomeService {
    public List<Book> gethotBooks();
    public Map<String,List<Book>> getGoodBooksFromClassification();
    public List<Book> getRankingBook();
}
