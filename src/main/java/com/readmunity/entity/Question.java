package com.readmunity.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/27.
 */
public class Question extends Base {

    private int bookId;
    /**
     * 1. 如果问题没被修改过，值为空.
     * 2. 如果问题被修改过，值为原始问题的id；
     */
    private String originalId;
    /**
     * 原始问题的为0.
     * 以此类推，0，1，2，3，4.。。
     */
    private int version;
    private String content;
    private String tags;
    private int starQty;
    private int voteQty;

    private List<Reply> replys = new ArrayList<Reply>();

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getStarQty() {
        return starQty;
    }

    public void setStarQty(int starQty) {
        this.starQty = starQty;
    }

    public int getVoteQty() {
        return voteQty;
    }

    public void setVoteQty(int voteQty) {
        this.voteQty = voteQty;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Reply> getReplys() {
        return replys;
    }

    public void setReplys(List<Reply> replys) {
        this.replys = replys;
    }
}
