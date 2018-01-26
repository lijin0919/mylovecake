package com.controller.admin;

import com.entity.Users;
import com.google.gson.Gson;
import com.service.IUserService;
import com.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class adminUserController {
    @Autowired
    private UserServiceImpl userService;



    /**
     * 去后台用户列表页面
     * @return
     */
    @GetMapping("/toAdminUserList")
    //要去数据获取所有用户信息
    public String toAdminUserList(Model userListModel){//userListModel用来存用户集合
        //调方法获取用户信息
        List<Users> usersList = userService.findUserList();
        //将集合存入userListModel中，去页面展示
        userListModel.addAttribute("userList",usersList);
        return "adminUserList";
    }

    /**
     * 去修改用户信息页面
     * @return
     */
    @GetMapping("/toAdminUserEdit")
    public String toAdminUserEdit(@RequestParam("userId") Integer userId,Model userModel){
        //获取数据库对象
        Users user = userService.findUserInfoByUserId(userId);
        //将用户存入Model中
        userModel.addAttribute("user",user);
        return "adminUserEdit";
    }

    /**
     * 去添加用户页面
     * @return
     */
    @GetMapping("/toAdminAddUser")
    public String toAdminAddUser(){
        return "adminAddUser";
    }

    /**
     * 去修改用户密码页面
     * @return
     */
    @GetMapping("/toAdminUserReset")
    public String toAdminUserReset(@RequestParam("userId") Integer userId,Model userModel){
        //先获取用户对象
        Users user = userService.findUserInfoByUserId(userId);
        //将用户信息存入Model中
        userModel.addAttribute("user",user);
        return "adminUserReset";
    }


    /**
     * 后台修改用户密码，检查密码是否正确
     * @param oldPassword
     * @param userId
     * @return
     */
    @PostMapping("/adminCheckPassword")
    @ResponseBody
    public String checkPassword(@RequestParam("oldPassword") String oldPassword,
                                 @RequestParam("userId") Integer userId){

        //获取数据库中的Users对象
        Users sqlUser = userService.findUserInfoByUserId(userId);
        //获取数据库密码
        String sqlPassword = sqlUser.getPassword();
        //标记
        boolean flag = false;
        //判断用户输入密码是否正确
        if (oldPassword.equals(sqlPassword)){
            flag = true;
        } else {
            flag = false;
        }
        return new Gson().toJson(flag);
    }


    @PostMapping("/adminChangePassword")
    @ResponseBody
    public String changePassword(@RequestParam("newPassword") String newPassword,
                                  @RequestParam("userId") Integer userId){
        //创建一个对象
        Users user = new Users();
        //为这个对象赋值
        user.setId(userId);
        user.setPassword(newPassword);
        //调用方法修改密码
        Integer result = userService.updatePassword(user);
        //判断是否修改
        boolean flag = false;
        if (result>0){
            flag=true;
        } else {
            flag=false;
        }
        return new Gson().toJson(flag);
    }

    @PostMapping("/adminChangeUserInfo")
    @ResponseBody
    public String changeUserInfo(@RequestParam("newName") String newName,
                                  @RequestParam("newUserPhone") String newUserPhone,
                                  @RequestParam("newUserAddress") String newUserAddress,
                                  @RequestParam("userId") Integer userId){//首先得获取页面发过来的信息

        //创建一个对象
        Users user = new Users();
        //为对象赋值
        user.setId(userId);
        user.setName(newName);
        user.setUserPhone(newUserPhone);
        user.setUserAddress(newUserAddress);

        //获得影响行数
        Integer result = userService.updateUserInfo(user);
        //判断结果
        boolean flag = false;
        if (result>0){
            flag = true;
        }else {
            flag = false;
        }
        return new Gson().toJson(flag);
    }



    @PostMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestParam("userId") Integer userId){
        Integer result = userService.deleteUser(userId);
        boolean flag = false;
        if (result>0){
            flag = true;
        }else {
            flag = false;
        }
        return new Gson().toJson(flag);
    }
}//class
