package com.smbms.dao;

import com.smbms.entity.User;

import java.util.List;

/**
 * 用户接口
 */
public interface UserMapper {

    //统计用户数量
    public int count();
    //查询用户集合
    public List<User> getUserList();

}
