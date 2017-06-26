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

    User getUserById(String id);

    User getUserByUsername(String username);

    User getUserByEmail(String email);

    void passEmailActivation(String username, String email, String validateCode) throws Exception;

    User updateProfileByName(String name, User user);

    User updateProfileByCurrentName(User user);

    User updateCurrent(Map<String, String> setParam);

    Message uploadAvatar(MultipartFile file);

    User cropAvatar(String path, int x, int y, int w, int h);

    Message getCurrentAvatar();

    List<User> getUserList(Map<String, String> filter);

    void passwordResetPassEmail(String toEmail) throws Exception;

    User parsingString(String info) throws Exception;

    void updatePasswordtoUser(String id, String password) throws Exception;

    void signUp(String username, String email, String password);

    User getLogin();
}
