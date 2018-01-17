package com.controller;

import com.entity.TestUser;
import com.mapper.ITestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    private ITestMapper mapper;

    @GetMapping("/test")
    public String test(){
        try{
            TestUser user = mapper.select();
            System.out.println(user.getUserName());
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "test";
    }
}
