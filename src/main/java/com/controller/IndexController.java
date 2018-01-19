package com.controller;

import com.entity.Top;
import com.entity.Types;
import com.service.ITopService;
import com.service.TopServiceImpl;
import com.service.TypeListImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("typeList")
public class IndexController {


    @Autowired
    private TopServiceImpl topService;
    @Autowired
    private TypeListImpl typeListService;

    @GetMapping("/index")
    public String getTypes(Model model,Model model1,Model model2,Model model3){

        try {
//            //进行查询
//            List<Top> topList = topService.getTopList();
//            model.addAttribute("topList",topList);
            //根据typeId查询
            List<Top> topList1 = topService.getTopListByTypeId(1);

            List<Top> topList2 = topService.getTopListByTypeId(2);

            List<Top> topList3 = topService.getTopListByTypeId(3);
            //获取typeList
            List<Types> typesList = typeListService.findTypeList();

            model.addAttribute("topList1",topList1);
            model.addAttribute("topList2",topList2);
            model.addAttribute("topList3",topList3);
            model.addAttribute("typeList",typesList);


        }catch (Exception e){
            e.printStackTrace();
        }

     return "index";
    }

}
