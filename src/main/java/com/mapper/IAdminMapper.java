package com.mapper;

import com.entity.Admins;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IAdminMapper {
    //根据管理用户的用户名和密码查询管理员用户信息
    @Select("SELECT * FROM admins WHERE username=#{userName} AND password=#{password}")
    Admins findAdminByUsernameAndPassword(Admins admins);

}
