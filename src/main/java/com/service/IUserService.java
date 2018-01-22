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
}
