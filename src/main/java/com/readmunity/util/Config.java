package com.readmunity.util;

import com.readmunity.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Henry on 17/5/29.
 */
public class Config {
    private static Config instance;

    private Config() {
    }

    public static Config getInstance() {    //对获取实例的方法进行同步
        if (instance == null) {
            synchronized (Config.class) {
                if (instance == null)
                    instance = new Config();
            }
        }
        return instance;
    }

    public List<Book> getBookListTest() {
        List<Book> list=new ArrayList<Book>();
        list.add(new Book("java编程思想", "本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。", "img/book/book-01.jpg"));
        list.add(new Book("Head First 设计模式", "强大的写作阵容。本书作者Eric Freeman；ElElisabeth Freeman是作家、讲师和技术顾问。Eric拥有耶鲁大学的计算机科学博", "img/book/未来已来.jpg"));
        list.add(new Book("大话设计模式", "本书为超级畅销书《大话设计模式》作者程杰潜心三年推出的扛鼎之作！以一个计算机教师教学为场景，讲解数据结构和相关算法的知识。", "img/book/幸运之书.jpg"));
        list.add(new Book("代码整洁之道", "Robert C. Martin，(Bob大叔)自1970年进入软件行业，从1990年起成为国际软件咨询师。是软件工程领域的大师级人物，是《敏捷软件开", "img/book/此刻花开.jpg"));
        list.add(new Book("代码大全", "《代码大全(第2版)》是著名IT畅销书作者Steve McConnell十一年前的经典著作的全新演绎：第二版不是第一版的简单修订增补，而是完全进行了重写；", "img/book/那片星空那片海.jpg"));
        list.add(new Book("编程珠玑", "Jon Bentley是位于新泽西州Murray Hill的朗讯贝尔实验室计算机科学研究中心的技术委员会委员，Jon自1998年就成为Dr. Dobb's Joumal杂志的特约编辑，", "img/book/领导力21法则.jpg"));
        return list;
    };


}
