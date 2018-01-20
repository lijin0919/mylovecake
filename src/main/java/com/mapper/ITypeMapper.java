package com.mapper;

import com.entity.Types;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.Type;
import java.util.List;
@Mapper
public interface ITypeMapper {
    /**
     * 首页商品类型映射
     */
    @Select("SELECT * FROM types;")
    @Results({
            @Result(id = true,property = "typeId",column = "id"),
            @Result(property = "typeName",column = "name")
    })
    List<Types> findTypeList();

    /**
     * 根据商品类型Id获取商品类型信息
     * @param typeId
     * @return
     */
    @Select("SELECT * FROM types WHERE id=#{typeId};")
    @Results({
            @Result(id = true,property = "typeId",column = "id"),
            @Result(property = "typeName",column = "name")
    })
    Types findTypeById(Integer typeId);
}
