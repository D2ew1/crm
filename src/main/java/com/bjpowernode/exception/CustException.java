package com.bjpowernode.exception;

/**
 * 自定义异常
 *
 * @author Dee
 * @date 2023-03-06 12:07
 */
public class CustException extends RuntimeException {

    private ErrorInfo errorInfo;
    private String errorCode;
    private String errorMessage;

    public CustException(ErrorInfo errorInfo) {
        super();
        this.errorInfo = errorInfo;
        this.errorCode = errorInfo.getCode();
        this.errorMessage = errorInfo.getMessage();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
