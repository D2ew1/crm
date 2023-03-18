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
            throw new DBException("��ѯʧ��");
        }

        if (user == null) {
            throw new LoginException("�û������������");
        }

        if (user.getLockStatus() == 0) {
            throw new LoginException("���û����������޷���¼��������������ϵ����Ա");
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
            throw new DBException("��ѯʧ��");
        }

        if (users == null) {
            throw new DBException("���������");
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
