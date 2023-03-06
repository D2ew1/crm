package com.bjpowernode.controller;

import com.bjpowernode.beans.DictionaryType;
import com.bjpowernode.dto.ResultDTO;
import com.bjpowernode.services.DictionaryTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @RequestMapping("getIds.action")
    public ResultDTO getIds() {

        ResultDTO resultDTO = new ResultDTO();

        ArrayList<String> ids = null;
        ids = typeServices.getIds();
        if (ids != null) {
            resultDTO.setResult(true);
            resultDTO.setData(ids);
            resultDTO.setMsg("��ѯ�ɹ�");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(ids);
            resultDTO.setMsg("��ѯʧ��");
        }

        return resultDTO;
    }

    @RequestMapping("getAll.action")
    public ResultDTO getAll() {

        ResultDTO resultDTO = new ResultDTO();

        ArrayList<DictionaryType> dictionaryTypes = null;
        dictionaryTypes = typeServices.getAll();
        if (dictionaryTypes != null) {
            resultDTO.setResult(true);
            resultDTO.setData(dictionaryTypes);
            resultDTO.setMsg("��ѯ�ɹ�");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(dictionaryTypes);
            resultDTO.setMsg("��ѯʧ��");
        }

        return resultDTO;
    }

    @RequestMapping("get.action")
    public ResultDTO get(String id) {

        ResultDTO resultDTO = new ResultDTO();

        DictionaryType dictionaryType = null;
        dictionaryType = typeServices.get(id);
        if (dictionaryType != null) {
            resultDTO.setResult(true);
            resultDTO.setData(dictionaryType);
            resultDTO.setMsg("��ѯ�ɹ�");
        } else {
            resultDTO.setResult(false);
            resultDTO.setData(dictionaryType);
            resultDTO.setMsg("�޶�Ӧ����");
        }

        return resultDTO;
    }

    @RequestMapping("add.action")
    public ResultDTO add(@RequestBody DictionaryType dictionaryType) {

        ResultDTO resultDTO = new ResultDTO();

        if (typeServices.add(dictionaryType)) {
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
    public ResultDTO edit(@RequestBody DictionaryType dictionaryType) {

        ResultDTO resultDTO = new ResultDTO();

        if (typeServices.edit(dictionaryType)) {
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

    /**
     * @param ids
     * @return
     * @RequestParamУ����������������δ��������������� ��ѡ���� requiredΪ trueʱ����ʾ������봫�ݲ�����
     * ��ѡ���� defaultValueΪĬ�ϲ���ֵ
     */
    @RequestMapping("del.action")
    public ResultDTO del(@RequestBody String[] ids) {

        ResultDTO resultDTO = new ResultDTO();

        if (typeServices.del(ids)) {
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
