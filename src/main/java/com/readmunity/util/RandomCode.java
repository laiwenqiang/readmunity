package com.readmunity.util;

import java.util.Random;

/**
 * Created by Henry on 17/6/20.
 */
public class RandomCode {
    private static RandomCode instance;

    private RandomCode() {
    }

    public static RandomCode getInstance() {    //对获取实例的方法进行同步
        if (instance == null) {
            synchronized (RandomCode.class) {
                if (instance == null)
                    instance = new RandomCode();
            }
        }
        return instance;
    }

    public static final String ABC123="abcdefghiklmnopqrstuvwxyz0123456789";
    public static final int SIZE=35;
    private Random random=new Random();

    public synchronized String getRandom(){
        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<SIZE;i++){
            buffer.append(ABC123.charAt(random.nextInt(ABC123.length())));
        }
        return buffer.toString().toUpperCase();
    }
}
