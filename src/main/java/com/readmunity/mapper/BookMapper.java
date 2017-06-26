package com.readmunity.mapper;

import org.springframework.stereotype.Component;

/**
 * Created by laiwenqiang on 2017/6/22.
 */
@Component(value = "bookMapper")
public interface BookMapper<Book> extends BaseMapper<Book> {

}
