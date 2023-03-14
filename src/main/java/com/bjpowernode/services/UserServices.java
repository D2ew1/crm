package com.bjpowernode.services;

import com.bjpowernode.beans.User;
import com.bjpowernode.exception.DBException;

import java.util.ArrayList;

public interface UserServices extends BaseServices<User, String> {
    ArrayList<User> getAll() throws DBException;
}
