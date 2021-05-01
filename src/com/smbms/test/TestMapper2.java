package com.smbms.test;

import com.smbms.dao.UserMapper;
import com.smbms.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestMapper2 {

    //目标1:获取一共有多少个用户
    @Test
    public void countUser(){
        //1.获取会话对象
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        //2.执行查询
        int count = sqlSession.selectOne("com.smbms.dao.UserMapper.count");
        //3.处理结果
        System.out.println("人数"+count);
        //4.关闭会话对象
        MyBatisUtil.closeSqlSession(sqlSession);

    }

    @Test
    public void countUser2(){
        //1.获取会话对象
        SqlSession sqlSession = MyBatisUtil.createSqlSession();
        //2.执行查询
        int count = sqlSession.getMapper(UserMapper.class).count();
        //3.处理结果
        System.out.println("人数"+count);
        //4.关闭会话对象
        MyBatisUtil.closeSqlSession(sqlSession);
    }

}
