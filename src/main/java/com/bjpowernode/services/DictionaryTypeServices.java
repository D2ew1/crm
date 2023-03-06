package com.bjpowernode.services;

import com.bjpowernode.beans.DictionaryType;

import java.util.ArrayList;

public interface DictionaryTypeServices extends BaseServices<DictionaryType, String> {
    ArrayList<String> getIds();
}
