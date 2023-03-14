package com.bjpowernode.services;

import com.bjpowernode.beans.DictionaryType;
import com.bjpowernode.exception.DBException;

import java.util.ArrayList;

public interface DictionaryTypeServices extends BaseServices<DictionaryType, String> {
    ArrayList<DictionaryType> getAll() throws DBException;
}
