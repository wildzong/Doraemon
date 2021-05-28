package com.doraemon.lottery.login.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    // 用户id
    private Long id;
    // 用户名
    private String userName;
    // 密码
    private String password;
    // token
    private String token;
}
