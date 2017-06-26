package com.readmunity.dao;

import com.readmunity.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/6/22.
 */
public interface BaseDao<T> {

    T getById(String id, BaseMapper mapper);

    T getOne(Map<String, String> filter, BaseMapper mapper);

    /**
     * 模糊（like）查询，filter为过滤条件
     * @param filter
     * @param mapper
     * @return
     */
    List<T> getListLike(Map<String, String> filter, BaseMapper mapper);

    List<T> getList(Map<String, String> filter, BaseMapper mapper);

    void updateById(String id, Map<String, String> param, BaseMapper mapper);

    void update(Map<String, String> setParam, Map<String, String> filterParam, BaseMapper mapper);

    void insert(Map<String, String> param, BaseMapper mapper);

}
