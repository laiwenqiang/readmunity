package com.readmunity.service.impl;

import com.readmunity.entity.Book;
import com.readmunity.service.WelcomeService;
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
        List<Book> arrayList=new ArrayList<Book>(10);
        for(int i=0;i<3;i++) {
            Book book1 = new Book("代码整洁之道"+i, "代码整洁之道说明代码整洁的重要性。");
            arrayList.add(book1);
        }
        return arrayList;
    }
    public Map<String,List<Book>> getGoodBooksFromClassification(){
        Map<String,List<Book>> map=new ConcurrentHashMap<String,List<Book>>(8);
        for(int i=0;i<8;i++) {
            List<Book> arrayList = new ArrayList<Book>(6);
            for (int j = 0; j < 6; j++) {
                Book book1 = new Book("代码整洁之道" + i, "代码整洁之道说明代码整洁的重要性。");
                arrayList.add(book1);
            }
            String classification="文学"+i;
            map.put(classification,arrayList);
        }
        return map;
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
