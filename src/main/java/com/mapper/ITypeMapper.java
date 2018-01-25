package com.mapper;

import com.entity.Types;
import org.apache.ibatis.annotations.*;

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
    Types findTypeById(@Param("typeId") Integer typeId);

    /**
     * 插入商品类目
     * @param name
     * @return
     */

    @Insert("INSERT INTO types(name) VALUES(#{name});")
    @Results({
            @Result(property = "name",column = "name")
    })
    Integer insertType(String name);

    /**
     * 根据类型id更新类型名
     * @param typeName
     * @param typeId
     * @return
     */
    @Update("UPDATE types SET name=#{typeName} WHERE id=#{typeId};")
    @Results({
            @Result(id = true,property = "typeId",column = "id"),
            @Result(property = "typeName",column = "name")
    })
    Integer changeTypeNameByTypeId(@Param("typeName") String  typeName,@Param("typeId")Integer typeId);

    /**
     * 根据类型id删除类型信息
     * @param typeId
     * @return
     */
    @Delete("DELETE  FROM types WHERE id=#{typeId}")
    @Results({
            @Result(id = true,property = "typeId",column = "id"),
    })
    Integer deleteTypeById(@Param("typeId")Integer typeId);
}
