package com.test;

/**
 * Created by laiwenqiang on 2017/5/25.
 */
public class Message {
    private final long id;
    private final String content;

    public Message(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
