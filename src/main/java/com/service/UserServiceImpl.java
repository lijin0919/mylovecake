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
    ////根据用户名密码获取用户信息
    public Users findUserInfoByUsername(String username, String password) {
            Users users=null;
            try{
                List<Users> usersList = iUserMapper.findUserInfoByUsernameAndPassword(username,password);
                if (usersList.size()>0) {
                    for (Users user : usersList
                            ) {
                        if (username.equals(user.getUsername())) {
                            users = user;
                        }
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();

            }
            return users;
    }

    /**
     * 根据用户Id查询用户信息
     * @param userId
     * @return
     */
    public Users findUserInfoByUserId(Integer userId) {
        Users user = iUserMapper.findUserInfoByUserId(userId);
        return user ;
    }


    /**
     * 修改用户信息:姓名、电话、地址
     * @param user
     * @return
     */
    public Integer updateUserInfo(Users user) {
        Integer result = iUserMapper.updateUserInfo(user);
        return result;
    }

    public String getUsernameByUserId(Integer id) {
        return iUserMapper.findUsernameByUserId(id);
    }

    /**
     * 修改用户密码
     * @param user
     * @return
     */
    public Integer updatePassword(Users user){
        Integer result = iUserMapper.updatePassword(user);
        return result;
    }
}
