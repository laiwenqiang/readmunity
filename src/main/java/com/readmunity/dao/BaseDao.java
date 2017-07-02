package com.readmunity.dao;

import com.readmunity.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/6/22.
 */
public interface BaseDao<T> {

    T getById(String id);

    T getOne(Map<String, String> filter);

    /**
     * 模糊（like）查询，filter为过滤条件
     * @param filter
     * @return
     */
    List<T> getListLike(Map<String, String> filter);

    List<T> getList(Map<String, String> filter);

    void updateById(String id, Map<String, String> param);

    void update(Map<String, String> setParam, Map<String, String> filterParam);

    void insert(Map<String, String> param);

}
