package com.readmunity.entity;

import com.readmunity.entity.Enum.ClassifictionState;

/**
 * Created by Henry on 17/5/29.
 */
public class Classification {
    private String id;
    private String name;
    private String fatherId;
    private Enum<ClassifictionState> state;

    public Classification(){}

    public Classification(String name){
        this.name=name;
    }

    public Classification(String id,String name){
        this(name);
        this.id=id;
        state=ClassifictionState.START;
    }

    public String getFatherId() {
        return fatherId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Enum<ClassifictionState> getState() {
        return state;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public void setState(Enum<ClassifictionState> state) {
        this.state = state;
    }
}
