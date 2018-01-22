package com.service;

import com.entity.Users;
import com.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserMapper iUserMapper;
    public Integer addUserInfo(Users user) {
        Integer result = iUserMapper.addUserInfo(user);
        return result;
    }

    public boolean findUserInfoByUsername(String username) {
        try{
            List<Users> usersList = iUserMapper.findUserInfoByUsername(username);
            System.out.println(usersList.size());
            if (usersList.size()>0){
                //如果为空则证明用户存在
                return true;
            } else {
                //否则
                return false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }
}
