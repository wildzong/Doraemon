package com.doraemon.microservice.login.dao;

import com.doraemon.microservice.login.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleDao {
    /**
     * 通过id获取该用户的角色列表
     * @param id
     * @return
     */
    List<Role> getUserRoleByUserId(@Param("id") Long id);
}
