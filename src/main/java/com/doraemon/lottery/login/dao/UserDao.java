package com.doraemon.lottery.login.dao;

import com.doraemon.lottery.login.entity.User;
import com.doraemon.lottery.login.entity.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    /**
     * 查询用户信息及角色信息
     * @param userName
     * @return
     */
    UserDTO selectUserByUsername(@Param("userName") String userName);

    /**
     * 通过userName获取UserEntity
     * @param userName
     * @return
     */
    User getUserByUsername(@Param("userName") String userName);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 更新密码
     * @param password
     * @param userName
     * @return
     */
    int updatePwd(@Param("password") String password, @Param("userName") String userName);

}
