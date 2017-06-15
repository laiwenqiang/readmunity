package com.readmunity.service.impl;

import com.readmunity.dao.UserDao;
import com.readmunity.entity.Enum.StatusInfo;
import com.readmunity.entity.Message;
import com.readmunity.entity.User;
import com.readmunity.service.UserService;
import com.readmunity.util.Config;
import com.readmunity.util.SendEmail;
import com.readmunity.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by laiwenqiang on 2017/5/29.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private SendEmail sendEmail;

    @Override
    public User getUserById(String id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public User getUserByCurrentUserName() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByUsername(name);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public void save(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setValidateCode(Config.getRandom());
        user.setRegisterTime(new Date());
        userDao.insert(user);
        sendEmail.signUpToEmail(username, email, user.getValidateCode());
    }

    @Override
    public void passEmailActivation(String username, String email, String validateCode) throws Exception {
        User user = userDao.getUserByEmail(email);
        if (user == null) {
            throw new ServiceException("该邮箱未注册（邮箱地址不存在）！");
        }
        if (!username.equals(user.getUsername())) {
            throw new ServiceException("该邮箱查询出来的信息不匹配！");
        }
        //验证用户激活状态
        if (StatusInfo.SUCCESS.getNumber() == user.getStatus()) {
            throw new ServiceException("邮箱已激活，请登录！");
        }
        if (StatusInfo.FAULT.getNumber() == user.getStatus()) {
            throw new ServiceException("用户信息已出错，请联系管理员！");
        }
        //验证激活码是否正确
        if (!validateCode.equals(user.getValidateCode())) {
            throw new ServiceException("激活码不正确");
        }

        Date currentTime = new Date();//获取当前时间
        //验证链接是否过期
        if (currentTime.after(user.getRegisterTime()) && currentTime.before(user.getLastActivateTime())) {
            //激活成功， //并更新用户的激活状态，为已激活
            System.out.println("==sq===" + user.getStatus());
            user.setStatus(StatusInfo.SUCCESS.getNumber());//把状态改为激活
            System.out.println("==sh===" + user.getStatus());
            userDao.updateUserByEmail(user);
        } else {
            throw new ServiceException("激活码已过期！");
        }
    }

    @Override
    public User updateProfileByName(String name, User user) {
        userDao.updateUserByName(name, user);
        return userDao.getUserByUsername(name);
    }

    @Override
    public User updateProfileByCurrentName(User user) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return updateProfileByName(name, user);
    }

    @Override
    public Message uploadAvatar(MultipartFile file) {
        if (file == null) {
            return null;
        }

        String name = file.getOriginalFilename();
        try {
            String tempDir = ClassLoader.getSystemResource("").getPath() + "static" + File.separator + "img"
                    + File.separator + "avatar" + File.separator + "temp";
            File tempFile = new File(tempDir);
            if (!tempFile.exists()) {
                tempFile.mkdirs();
            }
            name = tempDir + File.separator + name;
            file.transferTo(new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Message(HttpStatus.OK, "/img/avatar/temp/" + file.getOriginalFilename());
    }

    @Override
    public User cropAvatar(String path, int x, int y, int w, int h) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userDao.getUserByUsername(name);
        String dPath = File.separator + "img" + File.separator + "avatar" + File.separator + name + ".png";
        cropImage(path, dPath, x, y, w, h);
        user.setAvatar(dPath);
        userDao.updateUserByName(name, user);
        return userDao.getUserByUsername(name);
    }

    @Override
    public Message getCurrentAvatar() {
        User user = userDao.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        return new Message(HttpStatus.OK, user.getAvatar());
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    private BufferedImage cropImage(String oPath, String dPath, int x, int y, int w, int h) {
        try {
            oPath = File.separator + "static" + oPath;
            oPath = this.getClass().getResource(oPath).getFile();

            dPath = ClassLoader.getSystemResource("").getPath() + "static" + dPath;

            File oFile = new File(oPath);
            BufferedImage originalImgage = ImageIO.read(oFile);
            BufferedImage subImage = originalImgage.getSubimage(x, y, w, h);
            ImageIO.write(subImage, "png", new File(dPath));
            return subImage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
