package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserCenterController {
    @GetMapping("/userCenter")
    public String say(){
        return "userCenter";
    }
}
