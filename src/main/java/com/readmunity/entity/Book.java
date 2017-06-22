package com.readmunity.entity;

/**
 * Created by laiwenqiang on 2017/5/27.
 * update by Henry on 2017/5/27.
 */
public class Book extends Base {

    /**
     * 作者
     */
    private String author;
    /**
     * 类别
     */
    private String category;
    /**
     * 简介
     */
    private String overview;
    private String book_url;
    /**
     * 封面图片路径
     */
    private String cover;
    /**
     * 封面图片缩略图路径
     */
    private String thumbails;
    /**
     * 章节数量
     */
    private int chapterQty;
    /**
     * 提问数量
     */
    private int questionQty;
    /**
     * 回答数量
     */
    private int replyQty;

    /**
     * 当前在读人数
     */
    private int readingQty;

    /**
     * 已经读完人数
     */
    private int finishQty;

    /**
     * 被星标记的数量
     */
    private int starQty;
    /**
     * 被修改的次数
     */
    private int editedQty;


    public Book(String name, String overview) {
        this.name = name;
        this.overview = overview;
    }

    public Book(String name, String overview, String book_url) {
        this(name, overview);
        this.book_url = book_url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getThumbails() {
        return thumbails;
    }

    public void setThumbails(String thumbails) {
        this.thumbails = thumbails;
    }

    public int getChapterQty() {
        return chapterQty;
    }

    public void setChapterQty(int chapterQty) {
        this.chapterQty = chapterQty;
    }

    public int getQuestionQty() {
        return questionQty;
    }

    public void setQuestionQty(int questionQty) {
        this.questionQty = questionQty;
    }

    public int getReplyQty() {
        return replyQty;
    }

    public void setReplyQty(int replyQty) {
        this.replyQty = replyQty;
    }

    public int getReadingQty() {
        return readingQty;
    }

    public void setReadingQty(int readingQty) {
        this.readingQty = readingQty;
    }

    public int getFinishQty() {
        return finishQty;
    }

    public void setFinishQty(int finishQty) {
        this.finishQty = finishQty;
    }

    public int getStarQty() {
        return starQty;
    }

    public void setStarQty(int starQty) {
        this.starQty = starQty;
    }

    public int getEditedQty() {
        return editedQty;
    }

    public void setEditedQty(int editedQty) {
        this.editedQty = editedQty;
    }
}
