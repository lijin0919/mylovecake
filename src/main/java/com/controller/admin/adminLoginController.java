package com.controller.admin;

import com.entity.Admins;
import com.google.gson.Gson;
import com.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin
public class adminLoginController {
    @Autowired
    HttpSession session;

    @Autowired
    private AdminServiceImpl adminService;

    @GetMapping("/adminLogin")
    public String adminlogin() {
        return "adminLogin";
    }
    /**
     * 管理用户登陆判断
     */

    @PostMapping ("/adminLoginAction")
    @ResponseBody
    public String actionLogin(@RequestParam("loginUserName") String loginUserName, @RequestParam("loginPassword") String loginPassword){
        Admins admins=new Admins();
        admins.setUserName(loginUserName);
        admins.setPassword(loginPassword);
        boolean flag=false;
        Admins adminNew=adminService.getAdminByUsernameAndPassword(admins);
        if (adminNew!=null) {
            flag = true;
            session.setAttribute("admin", adminNew);
        }
        Gson gson = new Gson();
        System.out.println("adminLoginAction"+flag);
        return gson.toJson(flag);
    }


}
