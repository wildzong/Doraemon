package com.doraemon.microservice.login.service;

import com.doraemon.microservice.login.entity.User;
import com.doraemon.microservice.login.entity.dto.UserDTO;

public interface UserService {

    /**
     * 查询用户信息及角色信息
     * @param userName
     * @return
     */
    UserDTO selectUserByUsername(String userName);

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