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
            throw new DBException("查询失败");
        }

        if (dictionaryValues == null) {
            throw new DBException("无相关数据");
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
            throw new DBException("查询失败");
        }

        if (dictionaryValue == null) {
            throw new DBException("无相关数据");
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
            throw new DBException("添加失败");
        } catch (DuplicateKeyException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("添加失败，因为字典数值编号重复");
        }

        if (rows <= 0) {
            throw new DBException("添加失败");
        }
    }

    @Override
    public void edit(DictionaryValue dictionaryValue) {

        int rows = 0;
        try {
            rows = mapper.edit(dictionaryValue);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("修改失败");
        }

        if (rows <= 0) {
            throw new DBException("修改失败");
        }
    }

    @Override
    public void del(String[] ids) {

        int rows = 0;
        try {
            rows = mapper.del(ids);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("删除失败");
        } catch (BadSqlGrammarException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("删除失败，未选中任意行");
        }

        if (rows <= 0) {
            throw new DBException("删除失败");
        }
    }
}
