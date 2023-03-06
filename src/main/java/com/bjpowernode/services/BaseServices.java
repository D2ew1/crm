package com.bjpowernode.services;

import java.util.ArrayList;

public interface BaseServices<T, I> {

    ArrayList<T> getAll();

    T get(I id);

    boolean add(T t);

    boolean edit(T t);

    boolean del(I[] ids);

}
