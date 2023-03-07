package com.bjpowernode.exception;

/**
 * 
 *
 * @author Dee
 * @date 2023-03-06 12:20
 */
public enum CustErrors implements ErrorInfo {
    /**
     * �ղ�
     */
    EMPTY_PARAM("1","����Ϊ��");

    /**
     * �������
     */
    private String code;

    /**
     * ������Ϣ
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
