package com.readmunity.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Henry on 17/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleEmail(){
        SimpleMailMessage message =new SimpleMailMessage();
        message.setFrom("readtest@sina.com");
        message.setTo("cczhaoliang@126.com");
        message.setSubject("主题");
        message.setText("内容,测试");

        mailSender.send(message);
    }
}
