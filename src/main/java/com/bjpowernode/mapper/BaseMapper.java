package com.bjpowernode.mapper;

import com.bjpowernode.beans.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BaseMapper<T, I> {

    Integer count() throws SQLException;

    ArrayList<T> getAll() throws SQLException;

    T get(I id) throws SQLException;

    int add(T t) throws SQLException, DuplicateKeyException;

    int edit(T t) throws SQLException;

    int del(I[] ids) throws SQLException, BadSqlGrammarException, DataIntegrityViolationException;

}
