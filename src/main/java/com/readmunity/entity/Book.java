package com.readmunity.entity;

/**
 * Created by laiwenqiang on 2017/5/27.
 * update by Henry on 2017/5/27.
 */
public class Book {

    private String title;
    private String overview;
    private String book_url;

    public Book(String title, String overview) {
        this.title = title;
        this.overview = overview;
    }

    public Book(String title, String overview, String book_url) {
        this(title, overview);
        this.book_url = book_url;
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

    public String getBook_url() {
        return book_url;
    }

    public void setBook_url(String book_url) {
        this.book_url = book_url;
    }
}
