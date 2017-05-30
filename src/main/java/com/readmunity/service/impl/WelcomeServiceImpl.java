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
            Book book1 = new Book("我的抉择时刻"+i, i+"希拉里·克林顿权威传记，讲透其人生的每一个关键点与抉择时刻，洞悉在美国政坛不断缔造奇迹，永不止步的力量源泉。");
            arrayList.add(book1);
        }
        return arrayList;
    }
}
