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
 * @RestController ���õ�ͬ�� @Controller + @ResponseBody��
 * @ResponseBody �����ǽ� Controller�ķ������صĶ���ͨ���ʵ���ת����ת��Ϊָ���ĸ�ʽ֮��д�뵽 response����� body����ͨ���������� JSON���ݻ����� XML��
 * ע�������ʹ�� @ResponseBody�󲻻�������ͼ������������ֱ�ӽ�����д�뵽����(?��?)���У�Ч����ͬ��ͨ�� response�������ָ����ʽ�����ݡ�
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
        resultDTO.setMsg("��ѯ�ɹ�");
        return resultDTO;
    }

    @RequestMapping("getAll.action")
    public ResultDTO getAll() throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        ArrayList<DictionaryType> dictionaryTypes = typeServices.getAll();
        resultDTO.setResult(Result.success);
        resultDTO.setData(dictionaryTypes);
        resultDTO.setMsg("��ѯ�ɹ�");
        return resultDTO;
    }

    @RequestMapping("get.action")
    public ResultDTO get(String id) throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        DictionaryType dictionaryType = typeServices.get(id);
        resultDTO.setResult(Result.success);
        resultDTO.setData(dictionaryType);
        resultDTO.setMsg("��ѯ�ɹ�");
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
        resultDTO.setMsg("��ӳɹ�");
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
        resultDTO.setMsg("�޸ĳɹ�");
        return resultDTO;
    }

    /**
     * @param ids
     * @return
     * @RequestParamУ����������������δ��������������� ��ѡ���� requiredΪ trueʱ����ʾ������봫�ݲ�����
     * ��ѡ���� defaultValueΪĬ�ϲ���ֵ
     */
    @RequestMapping("del.action")
    public ResultDTO del(@RequestBody String[] ids) throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        typeServices.del(ids);
        resultDTO.setResult(Result.success);
        resultDTO.setData(null);
        resultDTO.setMsg("ɾ���ɹ�");
        return resultDTO;
    }
}
