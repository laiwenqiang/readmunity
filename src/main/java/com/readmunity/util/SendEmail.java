package com.readmunity.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by Henry on 17/6/11.
 */
@Component
@Scope("prototype")
public class SendEmail {

    @Value("${my.mail.username}")
    private String fromUsername;

    @Value("${my.program.url}")
    private String urlInfo;

    @Value("${my.mail.signUpSubject}")
    private String signUpSubject;

    @Value("${my.program.sign.emailActivation}")
    private String emailActivation;

    @Autowired
    private JavaMailSender mailSender;


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
        sb.append(urlInfo+emailActivation);
        sb.append("?username=");
        sb.append(username);
        sb.append("&email=");
        sb.append(email);
        sb.append("&validateCode=");
        sb.append(validateCode);
        sb.append("\"");
        sb.append(urlInfo+emailActivation);
        sb.append("?username=");
        sb.append(username);
        sb.append("&email=");
        sb.append(email);
        sb.append("&validateCode=");
        sb.append(validateCode);
        sb.append("</a>");

        sendHtmlMail(email,signUpSubject,sb.toString());
    }

    /**
     * 发送文本邮件
     * @param to
     * @param subject
     * @param content
     */
    public synchronized void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromUsername);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        try {
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    public synchronized void sendAttachmentsMail(String to, String subject, String content, String filePath){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(fromUsername);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
//helper.addAttachment("test"+fileName, file);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    /**
     * 发送正文中有静态资源（图片）的邮件
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     */
    public synchronized void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(fromUsername);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
