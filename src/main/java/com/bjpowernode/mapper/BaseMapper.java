package com.bjpowernode.mapper;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BaseMapper<T, I> {

    ArrayList<T> getAll() throws SQLException;

    T get(I id) throws SQLException;

    int add(T t) throws SQLException, DuplicateKeyException;

    int edit(T t) throws SQLException;

    int del(I[] ids) throws SQLException, BadSqlGrammarException, DataIntegrityViolationException;

}
