package com.doraemon.lottery.login.controller;

import com.doraemon.lottery.login.entity.User;
import com.doraemon.lottery.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseBody
    public User showUser() {
        return userService.getUserInfo("wildzong");
    }

    @PostMapping("/addUser")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
