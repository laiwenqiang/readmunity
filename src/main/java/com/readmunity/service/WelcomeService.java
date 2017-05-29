package com.readmunity.service;

import com.readmunity.entity.Book;
import com.readmunity.entity.SortHotBooks;

import java.util.List;
import java.util.Map;

/**
 * Created by Henry on 17/5/28.
 */
public interface WelcomeService {
    public List<Book> gethotBooks();
    public List<SortHotBooks> getGoodBooksFromClassification();
    public List<Book> getRankingBook();
}
