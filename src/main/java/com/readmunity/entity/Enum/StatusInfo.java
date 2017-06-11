package com.readmunity.entity.Enum;

/**
 * Created by Henry on 17/6/11.
 */
public enum StatusInfo {
    DEFORT(0),SUCCESS(1),FAULT(-1);

    private int number;
    private StatusInfo(int number){
        this.number=number;
    }
    public int getNumber(){
        return number;
    }

}
