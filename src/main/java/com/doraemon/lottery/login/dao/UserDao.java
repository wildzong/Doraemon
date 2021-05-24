package com.doraemon.lottery.login.dao;

import com.doraemon.lottery.login.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {
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
