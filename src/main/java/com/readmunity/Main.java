package com.readmunity;

import com.readmunity.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by laiwenqiang on 2017/5/26.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
//        new UserServiceImpl().getUserById("001");
    }
}
