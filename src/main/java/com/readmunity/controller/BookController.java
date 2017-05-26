package com.readmunity.controller;

import com.readmunity.entity.Book;
import com.readmunity.service.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/5/26.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getList(ModelMap map) {
//        map.addAttribute("", new BookServiceImpl().getList());

        List<Book> books = new ArrayList<>();
        books.add(new Book("java编程思想", "本书赢得了全球程序员的广泛赞誉，即使是最晦涩的概念，在Bruce Eckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到最高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。"));
        books.add(new Book("Head First 设计模式", "强大的写作阵容。本书作者Eric Freeman；ElElisabeth Freeman是作家、讲师和技术顾问。Eric拥有耶鲁大学的计算机科学博士学位，E1isabath拥有耶鲁大学的计算机科学硕士学位。FHBert Bates是畅销的HeadFirst系列书籍的创立者，也是Sun公司Java开发员认证考试的开发者。"));
        books.add(new Book("大话设计模式", "本书为超级畅销书《大话设计模式》作者程杰潜心三年推出的扛鼎之作！以一个计算机教师教学为场景，讲解数据结构和相关算法的知识。通篇以一种趣味方式来叙述，大量引用了各种各样的生活知识来类比，并充分运用图形语言来体现抽象内容，对数据结构所涉及到的一些经典算法做到逐行分析、多算法比较。与市场上的同类数据结构图书相比，本书内容趣味易读，算法讲解细致深刻，是一本非常适合自学的读物。"));
        books.add(new Book("代码整洁之道", "Robert C. Martin，(Bob大叔)自1970年进入软件行业，从1990年起成为国际软件咨询师。是软件工程领域的大师级人物，是《敏捷软件开发：原则、模式与实践》、《敏捷软件开发：原则、模式与实践(C#版)》（邮电）、《极限编程实践》（邮电）等国内引进的畅销书的作者，其中第一本原著荣获美国《软件开发》第13届震撼（Jolt）大奖，Martin的敏捷系列书是软件工程界的权威书籍。本书是他的又一最新力作。"));
        books.add(new Book("代码大全", "《代码大全(第2版)》是著名IT畅销书作者Steve McConnell十一年前的经典著作的全新演绎：第二版不是第一版的简单修订增补，而是完全进行了重写；增加了很多与时俱进的内容。这也是一本完整的软件构建手册，涵盖了软件构建过程中的所有细节。它从软件质量和编程思想等方面论述了软件构建的各个问题，并详细论述了紧跟潮流的新技术、高屋建瓴的观点、通用的概念，还含有丰富而典型的程序示例。"));
        books.add(new Book("编程珠玑", "Jon Bentley是位于新泽西州Murray Hill的朗讯贝尔实验室计算机科学研究中心的技术委员会委员，Jon自1998年就成为Dr. Dobb's Joumal杂志的特约编辑，他的“编程珠玑”专栏多年来一直是顶级学术杂志Communications of the ACM最风行的特色专栏之一，而本书正是建立在这些专栏的基础之上。"));

        map.addAttribute("books", books);
        return "booklist";
    }

}
