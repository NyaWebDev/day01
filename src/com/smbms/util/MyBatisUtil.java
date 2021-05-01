package com.smbms.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis工具类
 */
public class MyBatisUtil {
    //创建会话工厂，通过会话工厂直接得到会话
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 静态代码块，创建会话工厂对象
     */
    static{
        InputStream is = null;
        //1.读取配置文件
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //2.创建SqlSessionFactory会话工厂对象，完成对配置文件的读取
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建会话对象
     * @return
     */
    public static SqlSession createSqlSession(){
        //true表示自动提交事务、false手动提交事务
        return sqlSessionFactory.openSession(false);
    }

    /**
     * 关闭会话
     * @param sqlSession
     */
    public static void closeSqlSession(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

}
