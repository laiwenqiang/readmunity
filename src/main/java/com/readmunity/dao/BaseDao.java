package com.readmunity.dao;

import com.readmunity.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/6/22.
 */
public interface BaseDao<T> {
    /**
     * 模糊（like）查询，filter为过滤条件
     * @param filter
     * @param mapper
     * @return
     */
    List<T> getList(Map<String, String> filter, BaseMapper mapper);
}
