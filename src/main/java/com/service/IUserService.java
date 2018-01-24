package com.service;

import com.entity.Users;

import java.util.List;

public interface IUserService {
    //添加用户注册信息
    Integer addUserInfo(Users user);
    //根据用户名查询用户信息
    boolean findUserInfoByUsername(String username);
    //根据用户名密码获取用户信息
    Users findUserInfoByUsername(String username,String password);
    //根据用户ID查询用户信息
    Users findUserInfoByUserId(Integer userId);
    //修改用户信息:姓名、电话、地址
    Integer updateUserInfo(Users user);

}
