package com.readmunity.entity;

import java.util.List;

/**
 * Created by Henry on 17/5/29.
 */
public class SortHotBooks {
    private Classification classification;
    private List<Book> books;

    public SortHotBooks() {
    }

    public SortHotBooks(Classification classification, List<Book> books) {
        this.classification = classification;
        this.books = books;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
