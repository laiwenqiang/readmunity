package com.readmunity.dao.impl;

import com.readmunity.dao.BaseDao;
import com.readmunity.mapper.BaseMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/6/22.
 */
public abstract class AbstractDao<T> implements BaseDao<T> {

    abstract BaseMapper mapper();

    @Override
    public T getById(String id) {
        return (T) mapper().selectById(id);
    }

    @Override
    public T getOne(Map<String, String> filter) {
        if (isEmptyParam(filter)) {
            return null;
        }
        List<T> list = getList(filter);
        if (list != null) {
            if(list.size() > 1) return null;
            else return list.get(0);
        }
        return null;
    }

    @Override
    public List<T> getListLike(Map<String, String> filter) {
        if (isEmptyParam(filter)) {
            return null;
        }
        StringBuffer query = new StringBuffer(" 1 = 1 ");
        for (String key : filter.keySet()) {
            query.append("AND " + key + " LIKE '%" + filter.get(key) + "%' ");
        }
        return (List<T>)mapper().selectListLike(query.toString());
    }

    @Override
    public List<T> getList(Map<String, String> filter) {
        if (isEmptyParam(filter)) {
            return null;
        }
        StringBuffer query = new StringBuffer(" 1 = 1 ");
        for (String key : filter.keySet()) {
            query.append("AND " + key + " = '" + filter.get(key) + "'");
        }
        return (List<T>) mapper().selectList(query.toString());
    }

    @Override
    public void updateById(String id, Map<String, String> setParam) {
        if(isEmptyParam(setParam)) return;
        StringBuffer buffer = new StringBuffer("SET ");

        for (String key : setParam.keySet()) {
            buffer.append(key + " = '"  + setParam.get(key) + "', ");
        }
        buffer.delete(buffer.lastIndexOf(","), buffer.length());

        Map<String, String> param = new HashMap<>();
        param.put("setParam", buffer.toString());
        param.put("id", id);
        mapper().updateById(param);
    }

    @Override
    public void update(Map<String, String> setParam, Map<String, String> filterParam) {
        if (isEmptyParam(setParam) || isEmptyParam(filterParam)) {
            return;
        }
        StringBuffer setBuffer = new StringBuffer("SET ");
        StringBuffer filterBuffer = new StringBuffer(" 1 = 1 ");

        for (String key : setParam.keySet()) {
            setBuffer.append(key + " = '" + setParam.get(key) + "', ");
        }
        setBuffer.delete(setBuffer.lastIndexOf(","), setBuffer.length());

        for (String key : filterParam.keySet()) {
            filterBuffer.append("AND " + key + " = '" + filterParam.get(key) + "'");
        }

        Map<String, String> param = new HashMap<>();
        param.put("setParam", setBuffer.toString());
        param.put("filterParam", filterBuffer.toString());
        mapper().update(param);
    }

    @Override
    public void insert(Map<String, String> param) {
        if(isEmptyParam(param)) return;
        StringBuffer columnName = new StringBuffer("(");
        StringBuffer columnValue = new StringBuffer("(");

        for (String key : param.keySet()) {
            columnName.append(key + ",");
            columnValue.append("'" + param.get(key) + "',");
        }
        columnName.delete(columnName.lastIndexOf(","), columnName.length());
        columnName.append(")");
        columnValue.delete(columnValue.lastIndexOf(","), columnValue.length());
        columnValue.append(")");

        Map<String, String> params = new HashMap<>();
        params.put("columnName", columnName.toString());
        params.put("columnValue", columnValue.toString());
        mapper().insert(params);
    }

    private boolean isEmptyParam(Map<String, String> param) {
        if (param == null || param.isEmpty()) {
            return true;
        }
        return false;
    }
}
