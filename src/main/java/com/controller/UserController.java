package com.controller;

import com.entity.Users;
import com.google.gson.Gson;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
@CrossOrigin
@Controller
public class UserController {
    @Autowired
    HttpSession session;
    @Autowired
    private UserServiceImpl userService;
    /**
     * 跳转注册页面
     */
    @GetMapping("/register")
    public String register(){
        return "register";
    }


    /**
     * 验证用户名是否存在
     */
    @PostMapping("/checkUsername")
    @ResponseBody
    public String checkUsername(@RequestParam("username") String username){
        System.out.println(username);
        //调用方法查询
        boolean result = userService.findUserInfoByUsername(username);

        Gson gson = new Gson();


        System.out.println(result);
        return gson.toJson(result);
    }
    /**
     * 注册用户信息
     */

    @PostMapping("/actionRegister")
    public String actionRegister(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam("name") String name,
                      @RequestParam("userPhone") String userPhone,
                      @RequestParam("userAddress") String userAddress,
                      Model resultModel){
        //获取到所有数据的，赋值给User对象
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setUserPhone(userPhone);
        user.setUserAddress(userAddress);
        //将用户信息存入session中
        session.setAttribute("user",user);
        //调用方法添加用户信息
        Integer result = userService.addUserInfo(user);
        //将返回结果存入Model中
        resultModel.addAttribute("result",result);
        //获取表单数据
        return "index";
    }

    /**
     * 跳转登陆页面
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 用户登陆判断
     */
    @PostMapping("/actionLogin")
    public String actionLogin(){
        return "index";
    }

    /**
     * 退出登陆
     */

    @GetMapping("/logout")
    public String logout(){
        session.removeAttribute("user");
        Users user = (Users) session.getAttribute("user");
//        session.setAttribute("user",null);
        return "login";
    }


}//class
