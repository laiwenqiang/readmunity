package com.readmunity.entity;

/**
 * Created by laiwenqiang on 2017/5/27.
 */
public class Question {

    private String title;
    private String content;

    public Question(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
