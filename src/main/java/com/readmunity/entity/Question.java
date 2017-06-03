package com.readmunity.entity;

/**
 * Created by laiwenqiang on 2017/5/27.
 */
public class Question extends Base {

    private String name;
    /**
     * 1. 如果问题没被修改过，值为0.
     * 2. 如果问题被修改过，值为原始问题的id；
     */
    private String orId;
    /**
     * 原始问题的为0.
     * 以此类推，0，1，2，3，4.。。
     */
    private int version;
    private String content;
    private int star;
    private int vote;

    public Question() {}

    public Question(String name, String orId, int version, String content, int star, int vote, String id, String createdId,
                    String createdName, String createdTime) {
        this.name = name;
        this.orId = orId;
        this.version = version;
        this.content = content;
        this.star = star;
        this.vote = vote;
        this.id = id;
        this.createdId = createdId;
        this.createdName = createdName;
        this.createdTime = createdTime;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrId() {
        return orId;
    }

    public void setOrId(String orId) {
        this.orId = orId;
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

    public void setContent(String content)
    {
        this.content = content;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
