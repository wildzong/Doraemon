package com.doraemon.lottery.login.service.impl;

import com.doraemon.lottery.login.dao.UserDao;
import com.doraemon.lottery.login.entity.User;
import com.doraemon.lottery.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.addUser(user);
    }

    /**
     * 更新密码
     * @param oldPwd
     * @param newPwd
     * @return
     */
    public int updatePwd(String oldPwd, String newPwd){
        // 获取当前登录用户信息(注意：没有密码的)
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();

        // 通过用户名获取到用户信息（获取密码）
        User userInfo = userDao.getUserByUsername(username);

        // 判断输入的旧密码是正确
        if (passwordEncoder.matches(oldPwd, userInfo.getPassword())) {
            // 不要忘记加密新密码
            return userDao.updatePwd(username, passwordEncoder.encode(newPwd));
        }
        return 0;
    };
}
