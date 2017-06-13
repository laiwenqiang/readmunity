package com.readmunity.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Henry on 17/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailTest {
    @Value("${my.mail.username}")
    private String fromUsername;

    @Value("${my.program.url}")
    private String urlInfo;

    @Value("[Read Munity]邮箱验证")
    private String signUpSubject;

    @Value("${my.program.sign.emailActivation}")
    private String emailActivation;

    @Autowired
    private JavaMailSender mailSender;

    //@Test
    public void sendSimpleEmail(){
        SimpleMailMessage message =new SimpleMailMessage();
        message.setFrom("readtest@sina.com");
        message.setTo("cczhaoliang123456@126.com");
        message.setSubject("主题");
        message.setText("内容,测试");

        mailSender.send(message);
    }

    @Test
    public void sendHtmltest(){
        //System.out.println(signUpSubject);
        signUpToEmail("Henry","cczhaoliang@126.com","123");
    }
    /**
     * 拼接注册邮件信息
     * @param username
     * @param email
     * @param validateCode
     */
    public void signUpToEmail(String username, String email, String validateCode) {
        ///邮件的内容
        StringBuffer sb = new StringBuffer();
        sb.append("点击下面链接激活账号，24小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
        sb.append("<a href=\"");
        System.out.println(urlInfo+emailActivation);
        sb.append(urlInfo+emailActivation);
        sb.append("?username=");
        sb.append(username);
        sb.append("&email=");
        sb.append(email);
        sb.append("&validateCode=");
        sb.append(validateCode);
        sb.append("\">");
        sb.append(urlInfo+emailActivation);
        sb.append("?username=");
        sb.append(username);
        sb.append("&email=");
        sb.append(email);
        sb.append("&validateCode=");
        sb.append(validateCode);
        sb.append("</a>");

        System.out.println(sb.toString());
        System.out.println(signUpSubject);
       // sendHtmlMail(email,signUpSubject,sb.toString());
    }

    /**
     * 发送html邮件
     * @param to
     * @param subject
     * @param content
     */
    public synchronized void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
//true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(fromUsername);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
