package com.bjpowernode.exception;

/**
 * 数据库操作异常
 *
 * @author Dee
 * @date 2023-03-06 18:09
 */
public class DBException extends RuntimeException {

    public DBException() {
    }

    public DBException(String message) {
        super(message);
    }
}
