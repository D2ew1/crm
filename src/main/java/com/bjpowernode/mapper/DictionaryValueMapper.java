package com.bjpowernode.mapper;

import com.bjpowernode.beans.DictionaryValue;

import java.sql.SQLException;

public interface DictionaryValueMapper extends BaseMapper<DictionaryValue, String> {
    // 编辑字典类型时刷新字典数值缓存的待定方案
    int flushCache() throws SQLException;
}
