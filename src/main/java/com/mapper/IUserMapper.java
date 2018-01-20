package com.mapper;

import com.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IUserMapper {
    /**
     * 添加用户注册信息
     */
    @Insert("INSERT INTO users (username, password, name, phone, address) " +
            "VALUES (#{username},#{password},#{name},#{userPhone},#{userAddress});")
    Integer addUserInfo(Users user);

    /**
     * 根据username查询用户名是否存在
     */
    @Select("SELECT * FROM users WHERE username=#{username};")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "name",column = "name"),
            @Result(property = "userPhone",column = "phone"),
            @Result(property = "userAddress",column = "address")

    })
    List<Users> findUserInfoByUsername(@Param("username") String username);
}
