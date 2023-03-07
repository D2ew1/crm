package com.bjpowernode.exception;

/**
 * 
 *
 * @author Dee
 * @date 2023-03-06 12:20
 */
public enum CustErrors implements ErrorInfo {
    /**
     * 空参
     */
    EMPTY_PARAM("1","参数为空");

    /**
     * 错误代码
     */
    private String code;

    /**
     * 错误信息
     */
    private String message;

    private CustErrors(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
