package com.readmunity.util;

import javax.servlet.ServletContext;
import java.io.File;

/**
 * Created by laiwenqiang on 2017/6/13.
 */
public class PathUtil {

    public String avatar (String path) {
        path = File.separator + "static" + File.separator + path;
        path = this.getClass().getResource(path).getFile();
        return path;
    }

    public String avatarTemp(String path) {
        path = File.separator + "static" + File.separator + path;
        path = this.getClass().getResource(path).getFile();
        return null;
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "target" + File.separator;
        System.out.println(path);
    }
}
