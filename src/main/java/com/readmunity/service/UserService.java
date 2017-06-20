package com.readmunity.service;

import com.readmunity.entity.Message;
import com.readmunity.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by laiwenqiang on 2017/5/29.
 */
public interface UserService {

    User getUserByUsername(String username);

    User getUserByCurrentUserName();

    User getUserByEmail(String email);

    void save(String username, String email, String password);

    void passEmailActivation(String username, String email, String validateCode) throws Exception;

    User updateProfileByName(String name, User user);

    User updateProfileByCurrentName(User user);

    Message uploadAvatar(MultipartFile file);

    User cropAvatar(String path, int x, int y, int w, int h);

    Message getCurrentAvatar();

    List<User> getUserList(Map<String, String> filter);

    void passwordResetPassEmail(String toEmail) throws Exception;

    User parsingString(String info) throws Exception;

    void updatePasswordtoUser(User user,String password) throws Exception;
}
