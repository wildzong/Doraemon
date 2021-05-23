package com.doraemon.lottery.login.service;

import com.doraemon.lottery.login.dao.UserDao;
import com.doraemon.lottery.login.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserEntity getUserInfo(String username){
        return userDao.getUserByUsername(username);
    }
}