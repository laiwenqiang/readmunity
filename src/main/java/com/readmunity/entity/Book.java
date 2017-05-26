package com.readmunity.entity;

/**
 * Created by laiwenqiang on 2017/5/27.
 */
public class Book {

    private String title;
    private String overview;

    public Book(String title, String overview) {
        this.title = title;
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
