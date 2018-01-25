package com.controller.admin;

import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminUserController {
    @Autowired
    private IUserService userService;



    /**
     * 去后台用户列表页面
     * @return
     */
    @GetMapping("/toAdminUserList")
    //要去数据获取所有用户信息
    public String toAdminUserList(Model userListModel){//userListModel用来存用户集合
        return "adminUserList";
    }

    /**
     * 去修改用户信息页面
     * @return
     */
    @GetMapping("/toAdminUserEdit")
    public String toAdminUserEdit(){
        return "adminUserEdit";
    }

    /**
     * 去添加用户页面
     * @return
     */
    @GetMapping("/toAdminAddUser")
    public String toAdminAddUser(){
        return "AdminAddUser";
    }

    /**
     * 去修改用户密码页面
     * @return
     */
    @GetMapping("/toAdminUserReset")
    public String toAdminUserReset(){
        return "adminUserReset";
    }
}
