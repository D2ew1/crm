package com.bjpowernode.mapper;

import com.bjpowernode.beans.DictionaryType;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DictionaryTypeMapper extends BaseMapper<DictionaryType, String> {
    ArrayList<String> getIds() throws SQLException;
}
