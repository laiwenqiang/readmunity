package com.readmunity.service.impl;

import com.readmunity.entity.Book;
import com.readmunity.entity.Classification;
import com.readmunity.entity.SortHotBooks;
import com.readmunity.service.WelcomeService;
import com.readmunity.util.Config;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Henry on 17/5/28.
 */
@Service
public class WelcomeServiceImpl implements WelcomeService{
    public List<Book> gethotBooks(){
        return Config.getInstance().getBookListTest();
    }
    public List<SortHotBooks> getGoodBooksFromClassification(){
        List<SortHotBooks> sortHotBooklist=new ArrayList<SortHotBooks>(8);
        for(int i=0;i<8;i++) {
            String classification="文学"+i;
            sortHotBooklist.add(new SortHotBooks(new Classification(classification),Config.getInstance().getBookListTest()));
        }
        return sortHotBooklist;
    }

    public List<Book> getRankingBook(){
        List<Book> arrayList=new ArrayList<Book>(10);
        for(int i=0;i<10;i++) {
            Book book1 = new Book("我的抉择时刻"+i, "希拉里的最棒的回忆。");
            arrayList.add(book1);
        }
        return arrayList;
    }
}
