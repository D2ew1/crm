package com.bjpowernode.services;

import com.bjpowernode.beans.DictionaryType;
import com.bjpowernode.mapper.DictionaryTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return mapper.getIds();
    }

    @Override
    public ArrayList<DictionaryType> getAll() {
        return mapper.getAll();
    }

    @Override
    public DictionaryType get(String id) {
        return mapper.get(id);
    }

    @Override
    public boolean add(DictionaryType dictionaryType) {

        return mapper.add(dictionaryType) > 0;
    }

    @Override
    public boolean edit(DictionaryType dictionaryType) {
        return mapper.edit(dictionaryType) > 0;
    }

    @Override
    public boolean del(String[] ids) {
        return mapper.del(ids) > 0;
    }
}
