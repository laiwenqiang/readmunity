package com.readmunity.dao.impl;

import com.readmunity.dao.BaseDao;
import com.readmunity.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/6/22.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    @Override
    public List<T> getList(Map<String, String> filter, BaseMapper mapper) {
        StringBuffer query = new StringBuffer("WHERE 1 = 1 ");
        if (filter != null) {
            for (String key : filter.keySet()) {
                query.append("AND " + key + " LIKE '%" + filter.get(key) + "%' ");
            }
        }
        return mapper.getList(query.toString());
    }
}
