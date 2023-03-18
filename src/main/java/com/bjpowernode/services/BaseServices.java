package com.bjpowernode.services;

import com.bjpowernode.dto.Page;
import com.bjpowernode.exception.DBException;

import java.util.ArrayList;

public interface BaseServices<T, I> {

    default ArrayList<T> getAll() throws DBException {
        return null;
    }

    void getPage(Page page) throws DBException;

    T get(I id) throws DBException;

    void add(T t) throws DBException;

    void edit(T t) throws DBException;

    void del(I[] ids) throws DBException;

}
