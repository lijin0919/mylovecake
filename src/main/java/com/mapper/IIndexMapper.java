package com.mapper;

import com.entity.Types;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IIndexMapper {

    @Results(
            {
            @Result(id = true,property = "typeId",column = "id"),
            @Result(property = "typeName",column = "name")
    })
    @Select("SELECT * FROM types;")
    List<Types> selectTypes();

}
