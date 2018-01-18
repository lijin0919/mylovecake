package com.controller;

import com.entity.Top;
import com.service.ITopService;
import com.service.TopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
public class IndexController {


    @Autowired
   private TopServiceImpl topService;

    @GetMapping("/index")
    public String getTypes(Model model,Model model1,Model model2){

        try {
//            //进行查询
//            List<Top> topList = topService.getTopList();
//            model.addAttribute("topList",topList);
            //根据typeId查询
            List<Top> topList1 = topService.getTopListByTypeId(1);
            model.addAttribute("topList1",topList1);
            List<Top> topList2 = topService.getTopListByTypeId(2);
            model1.addAttribute("topList2",topList2);
            List<Top> topList3 = topService.getTopListByTypeId(3);
            model2.addAttribute("topList3",topList3);
//            System.out.println(topList1);

        }catch (Exception e){
            e.printStackTrace();
        }

     return "index";
    }

}
