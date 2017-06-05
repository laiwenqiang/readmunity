package com.readmunity.entity;

/**
 * Created by laiwenqiang on 2017/5/28.
 */
public class Reply extends Base{

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

    private String questionId;
    private String questionName;
    /**
     * 提问者的ID
     */
    private String questionerId;
    private String content;
    /**
     * 回答者的ID
     */
    private String responderId;
    private String responderName;
    /**
     * 回答被赞同的数量
     */
    private int agreementNum;
    private String summary;

    public Reply() {}

    public Reply(String id, String questionId, String questionName, String questionerId, String content, String responderId, String responderName, int agreementNum) {
        this.id = id;
        this.questionId = questionId;
        this.questionName = questionName;
        this.questionerId = questionerId;
        this.content = content;
        this.responderId = responderId;
        this.responderName = responderName;
        this.agreementNum = agreementNum;
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

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionerId() {
        return questionerId;
    }

    public void setQuestionerId(String questionerId) {
        this.questionerId = questionerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResponderId() {
        return responderId;
    }

    public void setResponderId(String responderId) {
        this.responderId = responderId;
    }

    public String getResponderName() {
        return responderName;
    }

    public void setResponderName(String responderName) {
        this.responderName = responderName;
    }

    public int getAgreementNum() {
        return agreementNum;
    }

    public void setAgreementNum(int agreementNum) {
        this.agreementNum = agreementNum;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
