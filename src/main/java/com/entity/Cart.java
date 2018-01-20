package com.entity;

import java.util.List;

public class Cart {
    private List<Goods> goodsList;
    private Integer totalNum;
    private Integer totalPricr;


    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPricr() {
        return totalPricr;
    }

    public void setTotalPricr(Integer totalPricr) {
        this.totalPricr = totalPricr;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "goodsList=" + goodsList +
                ", totalNum=" + totalNum +
                ", totalPricr=" + totalPricr +
                '}';
    }
}
