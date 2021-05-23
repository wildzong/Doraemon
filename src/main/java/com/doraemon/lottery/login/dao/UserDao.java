package com.doraemon.lottery.login.dao;

import com.doraemon.lottery.login.entity.UserEntity;
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
    UserEntity getUserByUsername(@Param("userName") String userName);
}
