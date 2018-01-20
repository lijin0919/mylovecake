package com.entity;

public class Goods {
    /**
     * 封装属性
     */
    private Integer goodId;//商品id
    private String goodName;//商品名称
    private String goodCover;//商品封面
    private String goodImage1;//细节图片1
    private String goodImage2;//细节图片2
    private Integer goodPrice;//商品价格
    private String goodIntro;//商品描述
    private Integer goodStock;//商品库存
    private Integer typeId;//类型id
    //购物车中商品数量
    private Integer goodsNum;
    //这个属性是要去service层去通过方法查询后，再set值
    private Types goodType;//商品类型


    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * 无参构造
     */
    public Goods() {
    }
    /**
     * 有参构造
     */
    public Goods(Integer goodId, String goodName, String goodCover, String goodImage1, String goodImage2, Integer goodPrice, String goodIntro, Integer goodStock, Integer typeId, Types goodType) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.goodCover = goodCover;
        this.goodImage1 = goodImage1;
        this.goodImage2 = goodImage2;
        this.goodPrice = goodPrice;
        this.goodIntro = goodIntro;
        this.goodStock = goodStock;
        this.typeId = typeId;
        this.goodType = goodType;
    }

    /**
     * 重写toString方法
     */
    @Override
    public String toString() {
        return "Goods{" +
                "goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", goodCover='" + goodCover + '\'' +
                ", goodImage1='" + goodImage1 + '\'' +
                ", goodImage2='" + goodImage2 + '\'' +
                ", goodPrice=" + goodPrice +
                ", goodIntro='" + goodIntro + '\'' +
                ", goodStock=" + goodStock +
                ", typeId=" + typeId +
                ", goodsNum=" + goodsNum +
                ", goodType=" + goodType +
                '}';
    }

    /**
     * getter和setter方法
     */
    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodCover() {
        return goodCover;
    }

    public void setGoodCover(String goodCover) {
        this.goodCover = goodCover;
    }

    public String getGoodImage1() {
        return goodImage1;
    }

    public void setGoodImage1(String goodImage1) {
        this.goodImage1 = goodImage1;
    }

    public String getGoodImage2() {
        return goodImage2;
    }

    public void setGoodImage2(String goodImage2) {
        this.goodImage2 = goodImage2;
    }

    public Integer getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Integer goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodIntro() {
        return goodIntro;
    }

    public void setGoodIntro(String goodIntro) {
        this.goodIntro = goodIntro;
    }

    public Integer getGoodStock() {
        return goodStock;
    }

    public void setGoodStock(Integer goodStock) {
        this.goodStock = goodStock;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Types getGoodType() {
        return goodType;
    }

    public void setGoodType(Types goodType) {
        this.goodType = goodType;
    }
}
