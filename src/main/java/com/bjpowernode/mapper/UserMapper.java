package com.bjpowernode.mapper;

import com.bjpowernode.beans.User;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface UserMapper extends BaseMapper<User, String> {
    User login(@Param("loginAct") String loginAct, @Param("loginPwd") String loginPwd) throws SQLException;
}
