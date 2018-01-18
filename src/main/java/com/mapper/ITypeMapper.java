package com.mapper;

import com.entity.Types;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITypeMapper {
    /**
     * 首页商品类型映射
     */
    @Select("SELECT * FROM types;")
    @Results({
            @Result(property = "typeId",column = "id"),
            @Result(property = "typeName",column = "name")
    })
    List<Types> getTypeList();


}
