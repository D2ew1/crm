package com.bjpowernode.exception;

/**
 * ���ݿ�����쳣
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
