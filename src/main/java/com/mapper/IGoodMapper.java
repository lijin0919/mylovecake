package com.mapper;

import com.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品表映射
 */
@Mapper
public interface IGoodMapper {

    /**
     * 根据商品id查商品
     * @param id
     * @return
     */

    @Select("SELECT * FROM goods WHERE id=#{id};")
    @Results({
            @Result(id = true,property = "goodId",column = "id"),
            @Result(property = "goodName",column = "name"),
            @Result(property = "goodCover",column = "cover"),
            @Result(property = "goodImage1",column = "image1"),
            @Result(property = "goodImage2",column = "image2"),
            @Result(property = "goodPrice",column = "price"),
            @Result(property = "goodIntro",column = "intro"),
            @Result(property = "goodStock",column = "stock"),
            @Result(property = "typeId",column = "type_id")
    })
    Goods findGoodById(Integer id);


    /**
     * 商品全查
     * @return
     */
    @Select("SELECT * FROM goods;")
    @Results({
            @Result(id = true,property = "goodId",column = "id"),
            @Result(property = "goodName",column = "name"),
            @Result(property = "goodCover",column = "cover"),
            @Result(property = "goodImage1",column = "image1"),
            @Result(property = "goodImage2",column = "image2"),
            @Result(property = "goodPrice",column = "price"),
            @Result(property = "goodIntro",column = "intro"),
            @Result(property = "goodStock",column = "stock"),
            @Result(property = "typeId",column = "type_id")
    })
    List<Goods> findGoodList();


    /**
     * 根据商品类型id查询商品
     *
     */
    @Select("SELECT * FROM goods WHERE type_id=#{Id};")
    @Results({
            @Result(id = true,property = "goodId",column = "id"),
            @Result(property = "goodName",column = "name"),
            @Result(property = "goodCover",column = "cover"),
            @Result(property = "goodImage1",column = "image1"),
            @Result(property = "goodImage2",column = "image2"),
            @Result(property = "goodPrice",column = "price"),
            @Result(property = "goodIntro",column = "intro"),
            @Result(property = "goodStock",column = "stock"),
            @Result(property = "typeId",column = "type_id")
    })
    List<Goods> findGoodListByTypeId(Integer Id);
}
