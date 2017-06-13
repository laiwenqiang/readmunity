package com.readmunity.service.impl;

import com.readmunity.dao.UserDao;
import com.readmunity.entity.Message;
import com.readmunity.entity.User;
import com.readmunity.service.UserService;
import com.readmunity.util.Config;
import com.readmunity.util.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        User user=new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setValidateCode(Config.getRandom());
        userDao.insert(user);
        sendEmail.signUpToEmail(username,email,user.getValidateCode());
    }

    @Override
    public void passEmailActivation(String username, String email, String validateCode) {

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
            if(!tempFile.exists()) {
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

    private BufferedImage cropImage(String oPath, String dPath, int x, int y, int w, int h){
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
