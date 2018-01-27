package com.util;

import com.entity.Goods;
import com.entity.Top;
import com.service.TopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

public class statusSet {

    public static List<Goods>  goodsListSet(List<Goods> goodsList,List<Top> topList){
        for (Goods goods:goodsList){
            goods.setTopLarge(false);
            goods.setTopScroll(false);
            goods.setTopSmall(false);
            for (Top top:topList) {
                if (goods.getGoodId().equals(top.getGoodId())){

                    if (2==top.getTypeId()){
                        goods.setTopLarge(true);
                    }
                    if (1==top.getTypeId()){
                        goods.setTopScroll(true);
                    }
                    if (3==top.getTypeId()){
                        goods.setTopSmall(true);
                    }
                }
            }
        }
        return goodsList;
    }
}
