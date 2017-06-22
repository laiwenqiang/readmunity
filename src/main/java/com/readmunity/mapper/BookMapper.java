package com.readmunity.mapper;

import com.readmunity.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by laiwenqiang on 2017/6/22.
 */
@Component(value = "bookMapper")
public interface BookMapper extends BaseMapper<Book> {
    List<Book> getBookList(String filter);
}
