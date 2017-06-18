package com.readmunity.util;

import com.readmunity.entity.User;
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
import javax.mail.internet.InternetAddress;
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

    @Value("[Read Munity] Email 验证")
    private String signUpSubject;

    @Value("[Read Munity] 请重置你的密码")
    private String passwordResetSubject;

    @Value("${my.program.sign.emailActivation}")
    private String emailActivation;

    @Value("${my.program.sign.passwordResetUrl}")
    private String passwordResetUrl;

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
        sb.append(getHtmlHead());
        sb.append("<body><h4>"+signUpSubject+"</h4>"+username+",<br />");
        sb.append("这封信是由 Read Munity 发送的。<br /> <br />");
        sb.append("您收到这封邮件，是由于在 Read Munity 进行了新用户注册，或是用户修改 Email 使用了这个邮箱地址。<br />");
        sb.append("如果您并没有访问过 Read Munity，或没有进行上述操作，请忽略这封邮件。<br />");
        sb.append("您不需要退订或进行其他进一步的操作。<br /><br />-------------------------------------------------------------<br />");
        sb.append("<b>账号激活说明</b><br />-------------------------------------------------------------<br /><br />");
        sb.append("如果您是 Read Munity 的新用户，或在修改您的注册 Email 时使用了本地址，");
        sb.append("我们需要对您的地址有效性进行验证以避免垃圾邮件或地址被滥用。<br /><br />");
        sb.append("您只需点击下面的链接即可激活您的帐号：<br />");
        sb.append("<a href=\"");
        sb.append(urlInfo+emailActivation);
        sb.append("?username=");
        sb.append(username);
        sb.append("&email=");
        sb.append(email);
        sb.append("&validateCode=");
        sb.append(validateCode);
        sb.append("\" >");
        sb.append(urlInfo+emailActivation);
        sb.append("?username=");
        sb.append(username);
        sb.append("&email=");
        sb.append(email);
        sb.append("&validateCode=");
        sb.append(validateCode);
        sb.append("</a>");
        sb.append(getHtmlEnd());
        sendHtmlMail(email,signUpSubject,sb.toString());
    }

    /**
     *  用于密码重置的连接。
     */
    public void passwordResetToEmail(User user){
        StringBuffer sb = new StringBuffer();
        sb.append(getHtmlHead());
        sb.append("<h4>"+passwordResetSubject+"</h4>"+user.getUsername()+",<br />");
        sb.append("这封信是由 Read Munity 发送的。<br /> <br />");
        sb.append("我们听说您失去了您的 Read Munity 密码。很抱歉!<br />");
        sb.append("但别担心!您可以使用以下链接重置您的密码:<br />");
        sb.append("<a href=\"");
        sb.append(urlInfo+passwordResetUrl);
        //这边要采用加密算法将邮件进行加密。和用户的时间进行加密。进行拼接。
        //防止一个注册加密码进行多次密码重置。
        sb.append(user.getEmail());
        sb.append("\" >");
        sb.append(urlInfo+passwordResetUrl);
        sb.append(user.getEmail());
        sb.append("</a>");
        sb.append(getHtmlEnd());
        sendHtmlMail(user.getEmail(),passwordResetSubject,sb.toString());
    }
    private String getHtmlHead(){
        StringBuffer sb = new StringBuffer();
        sb.append("<!DOCTYPE html>");
        sb.append("<html lang=\"zh-CN\"><head><meta charset=\"UTF-8\"></head><body>");
        return sb.toString();
    }
    private String getHtmlEnd(){
        StringBuffer sb = new StringBuffer();
        sb.append("<br /><br />(如果上面不是链接形式，请将该地址手工粘贴到浏览器地址栏再访问)<br /><br />");
        sb.append("感谢您的访问，祝您使用愉快！<br /><br />");
        sb.append("此致<br />Read Munity 管理团队.<br />http://www.ReadMunity.com/ <br />");
        sb.append("</body></html>");
        return sb.toString();
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
     * @param //to
     * @param subject
     * @param content
     */
    public synchronized void sendHtmlMail(String toEmail, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(new InternetAddress(fromUsername));
            helper.setTo(toEmail);
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
