package com.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class adminIndexController {
    @GetMapping("/adminIndex")
    public String adminlogin() {
        return "adminIndex";
    }
}
