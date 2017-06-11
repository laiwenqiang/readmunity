package com.readmunity.testDemo;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Random;

/**
 * Created by Henry on 17/6/11.
 */
public class RandomTest {
    public static final String ABC123="abcdefghiklmnopqrstuvwxyz0123456789";
    public static final int SIZE=15;

    public synchronized String getRandom(){
        StringBuffer buffer=new StringBuffer();
        Random random=new Random();
        for(int i=0;i<SIZE;i++){
            buffer.append(ABC123.charAt(random.nextInt(ABC123.length())));
        }
        return buffer.toString().toUpperCase();
    }
    @Test
    public void test(){
        String password=new RandomTest().getRandom();
        System.out.println(password);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println(hashedPassword);
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder.encode(password);
        System.out.println(hashedPassword2);
    }
}
