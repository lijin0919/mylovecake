package com.service;

import com.entity.Admins;

public interface IAdminService {
    //根据管理用户的用户名和密码查询管理员用户信息
    Admins getAdminByUsernameAndPassword(Admins admins);
}
