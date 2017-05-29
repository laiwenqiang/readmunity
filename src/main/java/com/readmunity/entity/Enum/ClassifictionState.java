package com.readmunity.entity.Enum;

/**
 * Created by Henry on 17/5/29.
 */
public enum ClassifictionState {
    START(0),DELETE(1);
    private int state;
    ClassifictionState(int i) {
        state=i;
    }

    public int getState(){
        return state;
    }

}
