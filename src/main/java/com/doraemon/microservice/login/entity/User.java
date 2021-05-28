package com.doraemon.microservice.login.entity;

import lombok.Data;

@Data
public class User {

    // 用户id
    private Long id;
    // 用户名
    private String userName;
    // 密码
    private String password;
    // token
    private String token;
}
