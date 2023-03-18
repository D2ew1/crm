package com.bjpowernode.exception;

/**
 * @author Dee
 * @date 2023-03-17 10:24
 */
public class LoginException extends RuntimeException {

    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }
}
