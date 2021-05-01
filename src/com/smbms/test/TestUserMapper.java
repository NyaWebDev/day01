package com.smbms.test;

import com.smbms.entity.Role;
import com.smbms.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUserMapper {

    //数据库会话对象
    SqlSession session = null;

    //所有核心代码执行之前执行的代码
    @Before
    public void before() throws IOException {
        //1.读取配置文件
        String resource = "mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        //2.创建sqlSessionFactory会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.创建sqlSession对象，执行Mapper操作
        session = factory.openSession();
        //通过读取UserMapper.xml文件的id,获得指定的SQL,进一步由MyBatis框架连接到数据库，执行SQL，得到结果

    }

    @After
    public void after(){
        //4.关闭会话对下你给
        session.close();
    }

    //测试统计用户数量
    @Test
    public void testCountUser() throws IOException {

        int count = 0;
        //selectOne查询单行单列的结果
        count = session.selectOne("com.smbms.dao.UserMapper.count");
        System.out.println("一共有学生:"+count+"个");

    }

    //显示用户列表
    @Test
    public void testGetUserList() throws IOException {

        //selectList查询多行多列，（列表）的结果
        List<User> userList = session.selectList("com.smbms.dao.UserMapper.getUserList");
        for(User user: userList){
            System.out.println(user.getUserName());
        }

    }

    //统计一共有多少个角色
    @Test
    public void testCountRole(){
        int num = session.selectOne("com.smbms.dao.RoleMapper.getNum");
        System.out.println("一共有"+num+"个角色");
    }

    public void showUserRoleList(){
        List<Role> list = session.selectList("com.smbms.dao.RoleMapper.getRoleList");
        for(Role role: list){
            System.out.println("用户角色名称:"+role.getRoleName());
        }

    }


}
