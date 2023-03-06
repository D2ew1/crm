package com.bjpowernode.mapper;

import java.util.ArrayList;

public interface BaseMapper<T, I> {

    ArrayList<T> getAll();

    T get(I id);

    int add(T t);

    int edit(T t);

    int del(I[] ids);

}
