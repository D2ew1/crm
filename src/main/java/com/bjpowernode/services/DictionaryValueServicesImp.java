package com.bjpowernode.services;

import com.bjpowernode.beans.DictionaryType;
import com.bjpowernode.beans.DictionaryValue;
import com.bjpowernode.mapper.DictionaryValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return mapper.getAll();
    }

    @Override
    public DictionaryValue get(String id) {
        return mapper.get(id);
    }

    @Override
    public boolean add(DictionaryValue dictionaryValue) {
        dictionaryValue.setId(UUID.randomUUID().toString().replace("-", ""));
        return mapper.add(dictionaryValue) > 0;
    }

    @Override
    public boolean edit(DictionaryValue dictionaryValue) {
        return mapper.edit(dictionaryValue) > 0;
    }

    @Override
    public boolean del(String[] ids) {
        return mapper.del(ids) > 0;
    }
}
