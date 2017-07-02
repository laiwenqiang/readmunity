package com.readmunity.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/6/22.
 */
public interface BaseMapper<T> {
    T selectById(String id);
    List<T> selectListLike(String filter);
    List<T> selectList(String filter);

    /**
     * param参数需要设置的内容：
     * setParam -> set的内容
     * id -> 表的主键
     * @param param
     */
    void updateById(Map<String, String> param);

    void update(Map<String, String> param);

    void insert(Map<String, String> param);
}
