package com.mapper;

import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;

@Mapper
public interface IOrderMapper {
    @Insert("INSERT INTO orders(total,amount,status,paytype,name,phone,address,systime,user_id) VALUES(#{total},#{amount},#{status},#{paytype},#{name},#{phone},#{address},#{systime},#{userId});")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "total",column = "total"),
            @Result(property = "amount",column = "amount"),
            @Result(property = "status",column = "status"),
            @Result(property = "paytype",column = "paytype"),
            @Result(property = "name",column = "name"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "address",column = "address"),
            @Result(property = "systime",column = "systime"),
            @Result(property = "userId",column = "user_id")
    })
    Integer insertOrder(@Param("total") Integer total, @Param("amount")Integer amount, @Param("status")byte status,@Param("paytype") byte paytype, @Param("name")String name, @Param("phone")String phone, @Param("address")String address, @Param("systime")Timestamp systime, @Param("userId")Integer userId);


    @Select("SELECT MAX(id) FROM orders;")
    Integer findMaxId();
}
