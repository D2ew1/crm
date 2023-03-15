package com.bjpowernode.services;

import com.bjpowernode.beans.DictionaryType;
import com.bjpowernode.dto.Page;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.mapper.DictionaryTypeMapper;
import com.bjpowernode.mapper.DictionaryValueMapper;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Dee
 * @date 2023-02-27 12:08
 */
@Service
public class DictionaryTypeServicesImp implements DictionaryTypeServices {

    @Autowired
    DictionaryTypeMapper mapper;

    // @Autowired
    // DictionaryValueMapper dictValueMapper;

    @Override
    public ArrayList<DictionaryType> getAll() {

        ArrayList<DictionaryType> dictionaryTypes = null;
        try {
            dictionaryTypes = mapper.getAll();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("查询失败");
        }

        if (dictionaryTypes == null) {
            throw new DBException("无相关数据");
        }

        return dictionaryTypes;
    }

    @Override
    public void getPage(Page page) throws DBException {

        Integer offset = page.getRowsPerPage();
        Integer currentPage = page.getCurrentPage();
        Map<String, Object> queryCond = page.getQueryCond();
        Integer amount = 0;
        try {
            amount = mapper.count(queryCond);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        page.setTotalRows(amount);
        Integer totalPages = 0;
        if (amount % offset == 0) {
            totalPages = amount / offset;
        } else {
            totalPages = amount / offset + 1;
        }
        page.setTotalPages(totalPages);
        if (totalPages > 0 && currentPage > totalPages) {
            currentPage = totalPages;
            page.setCurrentPage(currentPage);
        }
        Integer index = (currentPage - 1) * offset;

        ArrayList<DictionaryType> dictionaryTypes = null;
        try {
            dictionaryTypes = mapper.getPage(index, offset, queryCond);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("查询失败");
        }

        if (dictionaryTypes == null) {
            throw new DBException("无相关数据");
        }

        page.setData(dictionaryTypes);
    }

    @Override
    public DictionaryType get(String id) {

        DictionaryType dictionaryType = null;
        try {
            dictionaryType = mapper.get(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("查询失败");
        }

        if (dictionaryType == null) {
            throw new DBException("无相关数据");
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
            throw new DBException("添加失败");
        } catch (DuplicateKeyException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("添加失败，因为字典类型编号重复");
        }

        if (rows <= 0) {
            throw new DBException("添加失败");
        }
    }

    @Override
    public void edit(DictionaryType dictionaryType) {

        int rows = 0;
        try {
            rows = mapper.edit(dictionaryType);
            // dictValueMapper.flushCache();
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
        } catch (DataIntegrityViolationException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("删除失败，因为该类型拥有对应字典值");
        } catch (BadSqlGrammarException ex) {
            System.out.println(ex.getMessage());
            throw new DBException("删除失败，未选中任意行");
        }

        if (rows <= 0) {
            throw new DBException("删除失败");
        }
    }
}
