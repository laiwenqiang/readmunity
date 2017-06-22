package com.readmunity.service.impl;

import com.readmunity.entity.Book;
import com.readmunity.service.BookService;
import com.readmunity.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Created by laiwenqiang on 2017/6/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;
    @Test
    public void testGetBookList() {
        Map<String, String> filter = new HashMap<>();
        filter.put("id", "1");
        List<Book> bookList = bookService.getBookList(filter);
        assertNotNull(bookList);
    }
}
