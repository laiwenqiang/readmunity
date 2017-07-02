package com.readmunity.security;

import com.readmunity.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by laiwenqiang on 2017/6/26.
 */
public class CustUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CustUser(String username, String password, Collection<? extends GrantedAuthority> authorities, User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
