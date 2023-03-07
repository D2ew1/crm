package com.bjpowernode.services;

import com.bjpowernode.exception.CustException;
import com.bjpowernode.exception.DBException;

import java.util.ArrayList;

public interface BaseServices<T, I> {

    ArrayList<T> getAll() throws DBException;

    T get(I id) throws DBException;

    void add(T t) throws DBException;

    void edit(T t) throws DBException;

    void del(I[] ids) throws DBException;

}
