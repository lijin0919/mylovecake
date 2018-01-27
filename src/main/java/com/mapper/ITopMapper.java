package com.mapper;

import com.entity.Top;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * top表映射
 */
@Mapper
public interface ITopMapper {
    /**
     * 根据topid查询top类型
     * @param topId
     * @return
     */
    @Select("SELECT * FROM tops WHERE id=#{topId}")
    @Results({
            @Result(id = true,property = "topId",column = "id"),
            @Result(property = "goodId",column = "good_id"),
            @Result(property = "typeId",column = "type")

    })
    Top findTopListById(Integer topId);
    /**
     * 查询首页要显示的所有商品
     * @return
     */
    @Select("SELECT * FROM tops;")
    @Results({
            @Result(id = true,property = "topId",column = "id"),
            @Result(property = "goodId",column = "good_id"),
            @Result(property = "typeId",column = "type")
    })
    List<Top> findTopList();


    /**
     * 通过typeId查询top类型
     * @param typeId
     * @return
     */
    @Select("SELECT * FROM tops WHERE type=#{typeId}")
    @Results({
            @Result(id = true,property = "topId",column = "id"),
            @Result(property = "goodId",column = "good_id"),
            @Result(property = "typeId",column = "type")
    })
    List<Top> findTopListByTypeId(Integer typeId);

    /**
     * 插入top信息
     * @param goodId
     * @param typeId
     * @return
     */
    @Insert("INSERT INTO tops(good_id,type) VALUES(#{goodId},#{typeId});")
    @Results({
            @Result(id = true,property = "topId",column = "id"),
            @Result(property = "goodId",column = "good_id"),
            @Result(property = "typeId",column = "type")
    })
    Integer insertTop(@Param("goodId") Integer goodId,@Param("typeId")Integer typeId);

    /**
     * 根据商品id和类型id删除top信息
     * @param goodId
     * @param typeId
     * @return
     */
    @Delete("DELETE FROM tops WHERE 1=1 AND good_id=#{goodId} AND type=#{typeId}")
    @Results({
            @Result(id = true,property = "topId",column = "id"),
            @Result(property = "goodId",column = "good_id"),
            @Result(property = "typeId",column = "type")
    })
    Integer deleteTopByGoodIdAndType(@Param("goodId") Integer goodId,@Param("typeId")Integer typeId );
}
