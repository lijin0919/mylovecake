package com.mapper;

import com.entity.Goods;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 商品表映射
 */
public interface IGoodMapper {

    /**
     * 根据商品id查商品
     * @param id
     * @return
     */
//    private Integer goodId;//商品id
//    private String goodName;//商品名称
//    private String goodCover;//商品封面
//    private String goodImage1;//细节图片1
//    private String goodImage2;//细节图片2
//    private Integer goodPrice;//商品价格
//    private String goodIntro;//商品描述
//    private Integer goodStock;//商品库存
//    private Integer typeId;//类型id

    @Select("SELECT * FROM goods WHERE id=#{id};")
    @Results({
            @Result(property = "goodId",column = "id"),
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
            @Result(property = "goodId",column = "id"),
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
}
