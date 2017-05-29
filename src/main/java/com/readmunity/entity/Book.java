package com.readmunity.entity;

/**
 * Created by laiwenqiang on 2017/5/27.
 * update by Henry on 2017/5/27.
 */
public class Book {

    private String name;
    private String overview;
    private String book_url;

    public Book(String name, String overview) {
        this.name = name;
        this.overview = overview;
    }

    public Book(String name, String overview, String book_url) {
        this(name, overview);
        this.book_url = book_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBook_url() {
        return book_url;
    }

    public void setBook_url(String book_url) {
        this.book_url = book_url;
    }
}
