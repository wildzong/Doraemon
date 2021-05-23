package com.doraemon.lottery.login.service;

import com.doraemon.lottery.login.dao.UserDao;
import com.doraemon.lottery.login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    public User getUserInfo(String username){
        return userDao.getUserByUsername(username);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user){
        return userDao.addUser(user);
    }
}