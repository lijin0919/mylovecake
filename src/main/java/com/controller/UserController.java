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
    public String register() {
        return "register";
    }


    /**
     * 验证用户名是否存在
     */
    @PostMapping("/checkUsername")
    @ResponseBody
    public String checkUsername(@RequestParam("username") String username) {
        //调用方法查询
        boolean result = userService.findUserInfoByUsername(username);

        Gson gson = new Gson();


        return gson.toJson(result);
    }

    /**
     * 注册用户信息
     */

    @PostMapping("/actionRegister")
    @ResponseBody
    public String actionRegister(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("name") String name,
                                 @RequestParam("userPhone") String userPhone,
                                 @RequestParam("userAddress") String userAddress,
                                 Model resultModel) {
        //获取到所有数据的，赋值给User对象
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setUserPhone(userPhone);
        user.setUserAddress(userAddress);
        //将用户信息存入session中
        session.setAttribute("user", user);
        //调用方法添加用户信息
        boolean flag = false;
        Integer result = userService.addUserInfo(user);
        if (result > 0) {
            flag = true;
        }
        //将结果返回给页面
        return new Gson().toJson(flag);
    }

    /**
     * 跳转登陆页面
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 用户登陆判断
     */
    @PostMapping("/actionLogin")
    @ResponseBody
    public String actionLogin(@RequestParam("loginUserName") String loginUserName, @RequestParam("loginPassword") String loginPassword) {
        boolean flag = false;
        Users user = userService.findUserInfoByUsername(loginUserName, loginPassword);
        if (user != null) {
            flag = true;
            session.setAttribute("user", user);
        }
        Gson gson = new Gson();
        return gson.toJson(flag);
    }

    /**
     * 退出登陆
     */

    @GetMapping("/logout")
    public String logout() {
        session.removeAttribute("user");
        Users user = (Users) session.getAttribute("user");
//        session.setAttribute("user",null);
        return "login";
    }

    /**
     * 用户个人中心页面
     */
    @GetMapping("/userCenter")
    public String say() {
        return "userCenter";
    }


    /**
     * 修改用户信息页面
     */
    @PostMapping("/actionUserCenter")
    @ResponseBody
    //这里要先从表单获取数据，然后赋值给Users对象
    public String changeUserInfo(
            @RequestParam("newName") String newName,//获取用户姓名
            @RequestParam("newUserPhone") String newUserPhone,//获取用户电话
            @RequestParam("newUserAddress") String newUserAddress) {//获取用户地址
        //创建一个Users对象
        Users newUser = new Users();
        //获取session中的userId
        Users user = (Users) session.getAttribute("user");
        Integer userId = user.getId();

        //为对象赋值
        newUser.setName(newName);
        newUser.setUserPhone(newUserPhone);
        newUser.setUserAddress(newUserAddress);
        newUser.setId(userId);
        //将赋值的Users对象传参给Service方法
        Integer result = userService.updateUserInfo(newUser);
        System.out.println("result:" + result);
        //标记
        boolean flag = false;
        //判断返回影响行数，给页面返回结果
        if (result > 0) {
            //修改成功以后，将原来session中的对象数据要改
            session.removeAttribute("user");
            //清空以后，再根据userId查询一次获得Users对象
            Users newSessionUser = userService.findUserInfoByUserId(userId);
            //将newSessionUser重新存入session
            session.setAttribute("user", newSessionUser);
            flag = true;
            System.out.println("flag:" + flag);
        }
        //将结果返回到页面
        return new Gson().toJson(flag);
    }

    /**
     * 验证用户密码是否正确
     */
    @PostMapping("/checkPassword")
    @ResponseBody
    public String checkPassword(@RequestParam("oldPassword") String oldPassword) {
        //首先获取Users对象，再根据传入的秘密看是否匹配
        Users user = (Users) session.getAttribute("user");
        //获取userId
        Integer userId = user.getId();
        Users sqlUser = userService.findUserInfoByUserId(userId);
        String sqlPassword = sqlUser.getPassword();
        //判断传过来的密码，和数据库的密码是否匹配
        //标记
        boolean flag = false;
        if (sqlPassword.equals(oldPassword)) {//如果密码一致
            flag = true;
        }
        //将结果返回给页面
        return new Gson().toJson(flag);
    }

    @PostMapping("/changePassword")
    @ResponseBody
    public String changePassword(@RequestParam("newPassword") String newPassword) {
        System.out.println(newPassword);
        //首先获取Users对象，再根据传入的秘密看是否匹配
        Users user = (Users) session.getAttribute("user");
        //获取userId
        Integer userId = user.getId();
        //创建一个对象
        Users user1 = new Users();
        //为user1赋值
        user1.setPassword(newPassword);
        user1.setId(userId);
        //调用方法修改密码
        Integer result = userService.updatePassword(user1);
        boolean flag = false;
        if (result > 0) {
            flag = true;
        }
        return new Gson().toJson(flag);
    }
}//class
