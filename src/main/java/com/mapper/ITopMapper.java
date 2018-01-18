package com.mapper;

import com.entity.Top;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * top表映射
 */
public interface ITopMapper {
    /**
     * 根据topid查询top类型
     * @param id
     * @return
     */
    @Select("SELECT * FROM tops WHERE id=#{id}")
    @Results({
            @Result(id = true,property = "topId",column = "id"),
            @Result(property = "goodId",column = "good_id"),
    })
    Top findTopListById(Integer id);

    /**
     * 查询首页要显示的所有商品
     * @return
     */
    @Select("SELECT * FROM tops;")
    @Results({
            @Result(id = true,property = "topId",column = "id"),
            @Result(property = "goodId",column = "good_id"),
    })
    List<Top> findTopList();
}
