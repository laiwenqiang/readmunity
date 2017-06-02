package com.readmunity.entity;

import org.springframework.http.HttpStatus;

/**
 * Created by laiwenqiang on 2017/6/2.
 */
public class Message {
    private HttpStatus status;
    private Object result;

    public Message(HttpStatus status, Object result) {
        this.status = status;
        this.result = result;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
