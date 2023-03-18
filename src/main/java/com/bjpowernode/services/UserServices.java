package com.bjpowernode.services;

import com.bjpowernode.beans.User;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.exception.LoginException;

import java.util.ArrayList;

public interface UserServices extends BaseServices<User, String> {
    User login(String loginAct, String loginPwd) throws DBException, LoginException;
}
