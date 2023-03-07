package com.bjpowernode.controller.advice;

import com.bjpowernode.dto.ResultDTO;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.exception.InputException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ��ǿ������
 *
 * @author Dee
 * @date 2023-03-06 17:19
 */
@RestControllerAdvice
public class MyControllerAdvice {

    /**
     * �������쳣����Ϊ��λ
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(DBException.class)
    public ResultDTO dbExcpHandler(DBException ex) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(false);
        resultDTO.setData(null);
        resultDTO.setMsg(ex.getMessage());
        return resultDTO;
    }

    @ExceptionHandler(InputException.class)
    public ResultDTO inputExcpHandler(InputException ex) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(false);
        resultDTO.setData(null);
        resultDTO.setMsg(ex.getMessage());
        return resultDTO;
    }
}
