package com.service;

import com.entity.Users;

import java.util.List;

public interface IUserService {
    //添加用户注册信息
    Integer addUserInfo(Users user);
    //根据用户名查询用户信息
    boolean findUserInfoByUsername(String username);
}
