package com.bjpowernode.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public interface BaseMapper<T, I> {

    // �����ǿ���ֱ��������һ��ע�벢ʹ�ã������ǵ����� getPage()�и��ã����Լ�����@Param��
    Integer count(@Param("queryCond") Map<String, Object> queryCond) throws SQLException;

    ArrayList<T> getAll() throws SQLException;

    ArrayList<T> getPage(@Param("index") Integer index, @Param("offset") Integer offset, @Param("queryCond") Map<String, Object> queryCond) throws SQLException;

    T get(I id) throws SQLException;

    int add(T t) throws SQLException, DuplicateKeyException;

    int edit(T t) throws SQLException;

    int del(I[] ids) throws SQLException, BadSqlGrammarException, DataIntegrityViolationException;

}
