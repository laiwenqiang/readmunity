package com.readmunity.security;

import com.readmunity.entity.User;
import com.readmunity.service.UserService;
import com.readmunity.service.impl.UserServiceImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by laiwenqiang on 2017/6/8.
 */
public class CustUserDetailsService implements UserDetailsService {

    private UserService userService = new UserServiceImpl();

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUserByName(s);
        if(user != null) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
            grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
            return new org.springframework.security.core.userdetails.User(user.getName(),
                    user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("用户名不存在");
        }
    }
}
