package com.mapper;

import com.entity.TestUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ITestMapper {
    @Results({
            @Result(property = "userName",column = "user_name")
    })
    @Select("SELECT user_name FROM user_info WHERE id = 2;")
    TestUser select();
}
