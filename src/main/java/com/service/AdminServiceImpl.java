package com.service;

import com.entity.Admins;
import com.mapper.IAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private IAdminMapper iAdminMapper;


    //根据管理用户的用户名和密码查询管理员用户信息
    public Admins getAdminByUsernameAndPassword(Admins admins) {

        Admins admins1=iAdminMapper.findAdminByUsernameAndPassword(admins);
        return admins1;
    }


    /**
     * 修改后台管理员密码
     * @param admin
     * @return
     */
    public Integer updateAdminPassword(Admins admin) {
        Integer result = iAdminMapper.updateAdminPassword(admin);
        return result;
    }
}
