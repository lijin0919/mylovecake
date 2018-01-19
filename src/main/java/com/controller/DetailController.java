package com.controller;

import com.entity.Goods;
import com.entity.Types;
import com.service.DetailServiceImpl;
import com.service.GoodsTypesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DetailController {
    @Autowired
    private DetailServiceImpl detailService;
    @Autowired
    private GoodsTypesImpl goodsTypes;
    @GetMapping("/detail")
    public String say(@RequestParam("goodId") Integer goodId, Model goodModel,Model typeListModel){
       //获取商品信息
        Goods good = detailService.findGoodByGoodId(goodId);
        //将good放入Model中
        goodModel.addAttribute("good",good);
        //获取类型集合
        List<Types> typesList = goodsTypes.getGoodTypeLIst();
        //将集合放入Model中
        typeListModel.addAttribute("typeList",typesList);
     return "detail" ;
    }
}
