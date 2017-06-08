package com.readmunity.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by laiwenqiang on 2017/6/8.
 */
public class MyBatisUtil {
    private static final SqlSessionFactory ssf;

    static {
        String resource = "mybatis-config.xml";
        InputStream stream = null;

        try {
               stream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ssf = new SqlSessionFactoryBuilder().build(stream);
    }

    public static SqlSessionFactory getSessionFactory() {
        return ssf;
    }

}
