package com.bjpowernode.services;

import com.bjpowernode.beans.User;
import com.bjpowernode.dto.Page;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.exception.LoginException;
import com.bjpowernode.mapper.UserMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Dee
 * @date 2023-03-09 21:32
 */
@Service
public class UserServicesImp implements UserServices {

    @Autowired
    UserMapper mapper;

    @Override
    public User login(String loginAct, String loginPwd) throws DBException, LoginException {

        String salt = "NUI!$((Bp;mqwe,wVNSD1420*%#U(T*&";

        User user = null;
        try {
            user = mapper.login(loginAct, DigestUtils.md5Hex(loginPwd + salt));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("查询失败");
        }

        if (user == null) {
            throw new LoginException("用户名或密码错误");
        }

        if (user.getLockStatus() == 0) {
            throw new LoginException("该用户被锁定，无法登录，如有问题请联系管理员");
        }

        return user;
    }

    @Override
    public ArrayList<User> getAll() throws DBException {

        ArrayList<User> users = null;
        try {
            users = mapper.getAll();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("查询失败");
        }

        if (users == null) {
            throw new DBException("无相关数据");
        }

        return users;
    }


    @Override
    public void getPage(Page page) throws DBException {

    }

    @Override
    public User get(String id) throws DBException {
        return null;
    }

    @Override
    public void add(User user) throws DBException {

    }

    @Override
    public void edit(User user) throws DBException {

    }

    @Override
    public void del(String[] ids) throws DBException {

    }
}
