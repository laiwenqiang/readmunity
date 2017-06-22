package com.readmunity.mapper;

import java.util.List;

/**
 * Created by laiwenqiang on 2017/6/22.
 */
public interface BaseMapper<T> {
    List<T> getList(String filter);
}
