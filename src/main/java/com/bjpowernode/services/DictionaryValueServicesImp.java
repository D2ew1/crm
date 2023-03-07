package com.bjpowernode.services;

import com.bjpowernode.beans.DictionaryType;
import com.bjpowernode.beans.DictionaryValue;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.mapper.DictionaryValueMapper;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Dee
 * @date 2023-02-27 12:25
 */
@Service
public class DictionaryValueServicesImp implements DictionaryValueServices {

    @Autowired
    DictionaryValueMapper mapper;

    @Override
    public ArrayList<DictionaryValue> getAll() {

        ArrayList<DictionaryValue> dictionaryValues = null;
        try {
            dictionaryValues = mapper.getAll();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("��ѯʧ��");
        }

        if (dictionaryValues == null) {
            throw new DBException("���������");
        }

        return dictionaryValues;
    }

    @Override
    public DictionaryValue get(String id) {

        DictionaryValue dictionaryValue = null;
        try {
            dictionaryValue = mapper.get(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("��ѯʧ��");
        }

        if (dictionaryValue == null) {
            throw new DBException("���������");
        }

        return dictionaryValue;
    }

    @Override
    public void add(DictionaryValue dictionaryValue) {

        int rows = 0;
        try {
            dictionaryValue.setId(UUID.randomUUID().toString().replace("-", ""));
            rows = mapper.add(dictionaryValue);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("���ʧ��");
        } catch (DuplicateKeyException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("���ʧ�ܣ���Ϊ�ֵ���ֵ����ظ�");
        }

        if (rows <= 0) {
            throw new DBException("���ʧ��");
        }
    }

    @Override
    public void edit(DictionaryValue dictionaryValue) {

        int rows = 0;
        try {
            rows = mapper.edit(dictionaryValue);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("�޸�ʧ��");
        }

        if (rows <= 0) {
            throw new DBException("�޸�ʧ��");
        }
    }

    @Override
    public void del(String[] ids) {

        int rows = 0;
        try {
            rows = mapper.del(ids);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("ɾ��ʧ��");
        } catch (BadSqlGrammarException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("ɾ��ʧ�ܣ�δѡ��������");
        }

        if (rows <= 0) {
            throw new DBException("ɾ��ʧ��");
        }
    }
}
