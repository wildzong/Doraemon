package com.doraemon.microservice.login.entity;

import lombok.Data;

@Data
public class Menu {
    private Long id;
    private String menuName;
    private String menuUrl;
}
