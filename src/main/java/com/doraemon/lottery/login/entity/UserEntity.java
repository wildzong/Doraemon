package com.doraemon.lottery.login.entity;

import lombok.Data;

@Data
public class UserEntity {

    // 用户id
    private Long id;
    // 用户名
    private String userName;
    // 密码
    private String password;
    // token
    private String token;
    // role
    private String role;
}
