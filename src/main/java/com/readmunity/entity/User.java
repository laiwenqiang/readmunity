package com.readmunity.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/29.
 * Update by Henry on 2017/6/11 增加邮件验证机制
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    /**
     * 增加邮件验证机制
     */
    private int status;//激活状态
    private String validateCode;//激活码
    private Date registerTime;//注册时间

    /**
     * 头像url
     */
    private String avator;
    private String address;
    private String email;
    private String qq;
    private String weibo;
    private String github;
    private String twitter;

    /**
     * 积分、成就
     */
    private int score;
    private String reputation;

    private List<Book> starBookList = new ArrayList<>();
    private List<Question> questionList = new ArrayList<>();
    private List<Reply> replyList = new ArrayList<>();

    public User(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvator() {
        return avator;
    }

    public void setAvator(String avator) {
        this.avator = avator;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public List<Book> getStarBookList() {
        return starBookList;
    }

    public void setStarBookList(List<Book> starBookList) {
        this.starBookList = starBookList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public int getStatus() {
        return status;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    @Override
    public String toString() {
        return "id: " + id +"\n" + "username: " + username;
    }
}
