package com.readmunity.security;

import com.readmunity.entity.User;
import com.readmunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by laiwenqiang on 2017/6/8.
 */
@Component
public class CustUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    private User user;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        user = userService.getUserByUsername(s);
        if(user != null) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
            grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
            return new CustUser(user.getUsername(),
                    user.getPassword(), grantedAuthorities, user);
        } else {
            throw new UsernameNotFoundException("用户名不存在");
        }
    }
}
