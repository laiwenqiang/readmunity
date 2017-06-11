package com.readmunity.testDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Henry on 17/6/11.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GetPropertiesTest {
    @Value("${myMail.username}")
    private String username;

    BCryptPasswordEncoder passwordEncoder;

    @Test
    public void test(){
        System.out.print(username);
    }
}
