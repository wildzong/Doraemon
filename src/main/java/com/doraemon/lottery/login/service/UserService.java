package com.doraemon.lottery.login.service;

import com.doraemon.lottery.login.entity.User;

public interface UserService {

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    User getUserInfo(String username);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 更新密码
     * @param oldPwd
     * @param newPwd
     * @return
     */
    int updatePwd(String oldPwd, String newPwd);
}