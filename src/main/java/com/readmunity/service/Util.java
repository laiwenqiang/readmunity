package com.readmunity.service;

import com.readmunity.security.CustUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by laiwenqiang on 2017/7/2.
 */
@Component
public class Util {

    public static String getCurrentId() {
        int id = ((CustUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
        return String.valueOf(id);
    }

    public static String getCurrentName() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return name;
    }
}
