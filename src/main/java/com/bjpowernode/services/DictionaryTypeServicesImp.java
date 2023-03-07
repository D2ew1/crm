package com.bjpowernode.services;

import com.bjpowernode.beans.DictionaryType;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.mapper.DictionaryTypeMapper;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Dee
 * @date 2023-02-27 12:08
 */
@Service
public class DictionaryTypeServicesImp implements DictionaryTypeServices {

    @Autowired
    DictionaryTypeMapper mapper;

    @Override
    public ArrayList<String> getIds() {

        ArrayList<String> ids = null;
        try {
            ids = mapper.getIds();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("��ѯʧ��");
        }

        if (ids == null) {
            throw new DBException("���������");
        }

        return ids;
    }

    @Override
    public ArrayList<DictionaryType> getAll() {

        ArrayList<DictionaryType> dictionaryTypes = null;
        try {
            dictionaryTypes = mapper.getAll();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("��ѯʧ��");
        }

        if (dictionaryTypes == null) {
            throw new DBException("���������");
        }

        return dictionaryTypes;
    }

    @Override
    public DictionaryType get(String id) {

        DictionaryType dictionaryType = null;
        try {
            dictionaryType = mapper.get(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("��ѯʧ��");
        }

        if (dictionaryType == null) {
            throw new DBException("���������");
        }

        return dictionaryType;
    }

    @Override
    public void add(DictionaryType dictionaryType) {

        int rows = 0;
        try {
            rows = mapper.add(dictionaryType);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("���ʧ��");
        } catch (DuplicateKeyException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("���ʧ�ܣ���Ϊ�ֵ����ͱ���ظ�");
        }

        if (rows <= 0) {
            throw new DBException("���ʧ��");
        }
    }

    @Override
    public void edit(DictionaryType dictionaryType) {

        int rows = 0;
        try {
            rows = mapper.edit(dictionaryType);
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
        } catch (DataIntegrityViolationException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("ɾ��ʧ�ܣ���Ϊ������ӵ�ж�Ӧ�ֵ�ֵ");
        } catch (BadSqlGrammarException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("ɾ��ʧ�ܣ�δѡ��������");
        }

        if (rows <= 0) {
            throw new DBException("ɾ��ʧ��");
        }
    }
}
