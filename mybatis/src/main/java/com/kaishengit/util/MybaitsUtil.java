package com.kaishengit.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import org.slf4j.Logger;

public class MybaitsUtil {


    private static SqlSessionFactory sqlSessionFactory = builderSqlSessionFactory();

    private static SqlSessionFactory builderSqlSessionFactory() {
        try {
            Reader reader  = Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            return sqlSessionFactory;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
    public static SqlSession getSqlSession(){
        return getSqlSessionFactory().openSession();
    }


}
