package com.mapper;

import com.entity.Top;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

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
            @Result(property = "typeId",column = "good_id"),

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
}
