package com.bjpowernode.services;

import com.bjpowernode.beans.User;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.mapper.UserMapper;
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
