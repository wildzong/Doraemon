package com.doraemon.lottery.login.entity.dto;

import com.doraemon.lottery.login.entity.Role;
import com.doraemon.lottery.login.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO extends User {
    private Set<Role> roles;
}
