package com.bjpowernode.services;

import com.bjpowernode.dto.Page;
import com.bjpowernode.exception.DBException;

public interface BaseServices<T, I> {

    void getPage(Page page) throws DBException;

    T get(I id) throws DBException;

    void add(T t) throws DBException;

    void edit(T t) throws DBException;

    void del(I[] ids) throws DBException;

}
