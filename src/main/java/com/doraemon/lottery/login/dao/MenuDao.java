package com.doraemon.lottery.login.dao;

import com.doraemon.lottery.login.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuDao {

    /**
     * 根据角色id获取menu列表
     * @param roleIds
     * @return
     */
    List<Menu> getRoleMenuByRoles(@Param("roleIds") List<Long> roleIds);
}
