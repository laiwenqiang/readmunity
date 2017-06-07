package com.readmunity.service;

import com.readmunity.entity.Tag;

import java.util.List;

/**
 * Created by laiwenqiang on 2017/6/7.
 */
public interface TagService {
    List<String> getTagNameList(String query);
}
