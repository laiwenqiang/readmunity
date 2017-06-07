package com.readmunity.service.impl;

import com.readmunity.entity.Tag;
import com.readmunity.service.TagService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laiwenqiang on 2017/6/7.
 */
public class TagServiceImpl implements TagService{
    @Override
    public List<String> getTagNameList(String query) {
        List<String> tags = new ArrayList<>();
        tags.add("java");
        tags.add("php");
        tags.add("c++");

        return tags;
    }
}
