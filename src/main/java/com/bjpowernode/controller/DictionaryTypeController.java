package com.bjpowernode.controller;

import com.bjpowernode.beans.DictionaryType;
import com.bjpowernode.dto.Result;
import com.bjpowernode.dto.ResultDTO;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.exception.CustException;
import com.bjpowernode.exception.InputException;
import com.bjpowernode.services.DictionaryTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dee
 * @date 2023-02-27 12:24
 */

/**
 * @RestController 作用等同于 @Controller + @ResponseBody；
 * @ResponseBody 作用是将 Controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到 response对象的 body区，通常用来返回 JSON数据或者是 XML；
 * 注意事项：在使用 @ResponseBody后不会再走视图处理器，而是直接将数据写入到输入(?出?)流中，效果等同于通过 response对象输出指定格式的数据。
 */
@RestController
@RequestMapping("/dictionaryType")
public class DictionaryTypeController {

    @Autowired
    DictionaryTypeServices typeServices;

    @RequestMapping("getNames.action")
    public ResultDTO getNames() throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        ArrayList<String> names = typeServices.getNames();
        resultDTO.setResult(Result.success);
        resultDTO.setData(names);
        resultDTO.setMsg("查询成功");
        return resultDTO;
    }

    @RequestMapping("getAll.action")
    public ResultDTO getAll() throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        ArrayList<DictionaryType> dictionaryTypes = typeServices.getAll();
        resultDTO.setResult(Result.success);
        resultDTO.setData(dictionaryTypes);
        resultDTO.setMsg("查询成功");
        return resultDTO;
    }

    @RequestMapping("get.action")
    public ResultDTO get(String id) throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        DictionaryType dictionaryType = typeServices.get(id);
        resultDTO.setResult(Result.success);
        resultDTO.setData(dictionaryType);
        resultDTO.setMsg("查询成功");
        return resultDTO;
    }

    @RequestMapping("add.action")
    public ResultDTO add(@Valid @RequestBody DictionaryType dictionaryType, BindingResult bindingResult) throws DBException, InputException {

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            throw new InputException(fieldError.getDefaultMessage());
        }

        ResultDTO resultDTO = new ResultDTO();
        typeServices.add(dictionaryType);
        resultDTO.setResult(Result.success);
        resultDTO.setData(null);
        resultDTO.setMsg("添加成功");
        return resultDTO;
    }

    @RequestMapping("edit.action")
    public ResultDTO edit(@Valid @RequestBody DictionaryType dictionaryType, BindingResult bindingResult) throws DBException, InputException {

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            throw new InputException(fieldError.getDefaultMessage());
        }

        ResultDTO resultDTO = new ResultDTO();
        typeServices.edit(dictionaryType);
        resultDTO.setResult(Result.success);
        resultDTO.setData(null);
        resultDTO.setMsg("修改成功");
        return resultDTO;
    }

    /**
     * @param ids
     * @return
     * @RequestParam校正请求参数名，修饰处理器方法参数； 可选参数 required为 true时，表示请求必须传递参数；
     * 可选参数 defaultValue为默认参数值
     */
    @RequestMapping("del.action")
    public ResultDTO del(@RequestBody String[] ids) throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        typeServices.del(ids);
        resultDTO.setResult(Result.success);
        resultDTO.setData(null);
        resultDTO.setMsg("删除成功");
        return resultDTO;
    }
}
