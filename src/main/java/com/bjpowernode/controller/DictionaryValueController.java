package com.bjpowernode.controller;

import com.bjpowernode.beans.DictionaryValue;
import com.bjpowernode.dto.Page;
import com.bjpowernode.dto.Result;
import com.bjpowernode.dto.ResultDTO;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.exception.InputException;
import com.bjpowernode.services.DictionaryValueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dee
 * @date 2023-02-27 21:20
 */
@RestController
@RequestMapping("/dictionaryValue")
public class DictionaryValueController {

    @Autowired
    DictionaryValueServices valueServices;

    @RequestMapping("getPage.action")
    public ResultDTO getPage(@RequestBody Page page) throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        valueServices.getPage(page);
        resultDTO.setResult(Result.success);
        resultDTO.setData(page);
        resultDTO.setMsg("查询成功");
        return resultDTO;
    }

    @RequestMapping("get.action")
    public ResultDTO get(String id) throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        DictionaryValue dictionaryValue = valueServices.get(id);
        resultDTO.setResult(Result.success);
        resultDTO.setData(dictionaryValue);
        resultDTO.setMsg("查询成功");
        return resultDTO;
    }

    @RequestMapping("add.action")
    public ResultDTO add(@Valid @RequestBody DictionaryValue dictionaryValue, BindingResult bindingResult) throws DBException, InputException {

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            System.out.println(fieldError);
            throw new InputException(fieldError.getDefaultMessage());
        }

        ResultDTO resultDTO = new ResultDTO();
        valueServices.add(dictionaryValue);
        resultDTO.setResult(Result.success);
        resultDTO.setData(null);
        resultDTO.setMsg("添加成功");
        return resultDTO;
    }

    @RequestMapping("edit.action")
    public ResultDTO edit(@Valid @RequestBody DictionaryValue dictionaryValue, BindingResult bindingResult) throws DBException, InputException {

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            throw new InputException(fieldError.getDefaultMessage());
        }

        ResultDTO resultDTO = new ResultDTO();
        valueServices.edit(dictionaryValue);
        resultDTO.setResult(Result.success);
        resultDTO.setData(null);
        resultDTO.setMsg("修改成功");
        return resultDTO;
    }

    @RequestMapping("del.action")
    public ResultDTO del(@RequestBody String[] ids) throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        valueServices.del(ids);
        resultDTO.setResult(Result.success);
        resultDTO.setData(null);
        resultDTO.setMsg("删除成功");
        return resultDTO;
    }
}
