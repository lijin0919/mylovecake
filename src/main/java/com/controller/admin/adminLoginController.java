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
    public String adminLogin() {
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
        return gson.toJson(flag);
    }

    /**
     * 去修改管理员密码页面
     * @return
     */
    @GetMapping("resetAdminPassword")
    public String toResetPage(){
        return "adminInfoReset";
    }
    /**
     * 修改后台管理员密码
     * @return
     */
    @PostMapping("/resetAdminPasswordAction")
    @ResponseBody
    public String resetAdminPassword(@RequestParam("newAdminPassword") String newAdminPassword,
                                     @RequestParam("adminId") Integer adminId){
        //创建一个Admins对象
        Admins admin = new Admins();
        //将页面发过来的数据赋值给这个对象
        admin.setId(adminId);
        admin.setPassword(newAdminPassword);

        System.out.println(admin);
        //调用方法修改密码
        Integer result = adminService.updateAdminPassword(admin);
        //判断
        boolean flag = false;
        if (result>0){
            flag = true;
        } else {
            flag = false;
        }
        System.out.println(flag);
        //将结果返回页面
        return new Gson().toJson(flag);
    }

    /**
     * 后台管理员退出
     * @return
     */
    @GetMapping("/adminLogout")
    public String logoutAdmin(){
        //清空session中的admin
        session.removeAttribute("admin");
        //返回登录页面
        return "adminLogin";
    }
}
