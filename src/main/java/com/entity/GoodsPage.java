package com.entity;

import java.util.List;

public class GoodsPage {
    private Integer currentPage;
    private Integer totalPage;
    private Integer goodsNumInPage;
    private List<Goods> goodsList;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getGoodsNumInPage(Integer goodsnuminpage) {
        return goodsNumInPage;
    }

    public void setGoodsNumInPage(Integer goodsNumInPage) {
        this.goodsNumInPage = goodsNumInPage;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "GoodsPage{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", goodsNumInPage=" + goodsNumInPage +
                ", goodsList=" + goodsList +
                '}';
    }
}
