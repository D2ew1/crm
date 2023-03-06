package com.bjpowernode.controller;

import com.bjpowernode.beans.DictionaryValue;
import com.bjpowernode.dto.ResultDTO;
import com.bjpowernode.services.DictionaryValueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Dee
 * @date 2023-02-27 21:20
 */
@RestController
@RequestMapping("/dictionaryValue")
public class DictionaryValueController {

    @Autowired
    DictionaryValueServices valueServices;

    @RequestMapping("getAll.action")
    public ResultDTO getAll() {

        ResultDTO resultDTO = new ResultDTO();

        ArrayList<DictionaryValue> dictionaryValues = null;
        dictionaryValues = valueServices.getAll();
        if (dictionaryValues != null) {
            resultDTO.setResult(true);
            resultDTO.setData(dictionaryValues);
            resultDTO.setMsg("��ѯ�ɹ�");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(dictionaryValues);
            resultDTO.setMsg("��ѯʧ��");
        }

        return resultDTO;
    }

    @RequestMapping("get.action")
    public ResultDTO get(String id) {

        ResultDTO resultDTO = new ResultDTO();

        DictionaryValue dictionaryValue = null;
        dictionaryValue = valueServices.get(id);
        if (dictionaryValue != null) {
            resultDTO.setResult(true);
            resultDTO.setData(dictionaryValue);
            resultDTO.setMsg("��ѯ�ɹ�");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(dictionaryValue);
            resultDTO.setMsg("�޶�Ӧ����");
        }

        return resultDTO;
    }

    @RequestMapping("add.action")
    public ResultDTO add(@RequestBody DictionaryValue dictionaryValue) {

        ResultDTO resultDTO = new ResultDTO();

        if (valueServices.add(dictionaryValue)) {
            resultDTO.setResult(true);
            resultDTO.setData(null);
            resultDTO.setMsg("��ӳɹ�");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(null);
            resultDTO.setMsg("���ʧ��");
        }

        return resultDTO;
    }

    @RequestMapping("edit.action")
    public ResultDTO edit(@RequestBody DictionaryValue dictionaryValue) {

        ResultDTO resultDTO = new ResultDTO();

        if (valueServices.edit(dictionaryValue)) {
            resultDTO.setResult(true);
            resultDTO.setData(null);
            resultDTO.setMsg("�޸ĳɹ�");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(null);
            resultDTO.setMsg("�޸�ʧ��");
        }

        return resultDTO;
    }

    @RequestMapping("del.action")
    public ResultDTO del(@RequestBody String[] ids) {

        ResultDTO resultDTO = new ResultDTO();

        if (valueServices.del(ids)) {
            resultDTO.setResult(true);
            resultDTO.setData(null);
            resultDTO.setMsg("ɾ���ɹ�");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(null);
            resultDTO.setMsg("ɾ��ʧ��");
        }

        return resultDTO;
    }
}
