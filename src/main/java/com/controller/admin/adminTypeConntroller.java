package com.controller.admin;

import com.entity.Order;
import com.entity.Types;
import com.google.gson.Gson;
import com.service.GoodsTypesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@CrossOrigin
public class adminTypeConntroller {
    @Autowired
    private GoodsTypesImpl goodsTypesImpl;
    @Autowired
    private HttpSession session;


    @GetMapping("/typeList")
    public String typeList() {
        List<Types> list=goodsTypesImpl.getGoodTypeLIst();
        session.setAttribute("typeList",list);
        return "adminType";
    }

    @PostMapping("/insertNewType")
    @ResponseBody
    public String insertNewType(@RequestParam("name")String  name) {
        Integer num=goodsTypesImpl.insertNewType(name);
        List<Types> list=goodsTypesImpl.getGoodTypeLIst();
        Types types= list.get(list.size() - 1);
        return new Gson().toJson(types);
    }

    @GetMapping("/toEditType")
    public String toEditType(@RequestParam("typeId") Integer typeId) {
        Types types=new Types();
        types=goodsTypesImpl.getTypesByTypeId(typeId);
        session.setAttribute("types",types);
        return "adminTypeEdit";
    }

    @PostMapping("/changeTypeName")
    @ResponseBody
    public String changeTypeName(@RequestParam("typeId") Integer typeId,@RequestParam("typeName")String  typeName) {


        Integer num=goodsTypesImpl.changeTypeNameById(typeName,typeId);
        return new Gson().toJson(num);
    }

    @PostMapping("/deleteTypeById")
    @ResponseBody
    public String deleteTypeById(@RequestParam("typeId") Integer typeId) {


        Integer num=goodsTypesImpl.deleteTypeById(typeId);
        return new Gson().toJson(num);
    }
}

