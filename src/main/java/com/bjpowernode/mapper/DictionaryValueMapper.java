package com.bjpowernode.mapper;

import com.bjpowernode.beans.DictionaryValue;

import java.sql.SQLException;

public interface DictionaryValueMapper extends BaseMapper<DictionaryValue, String> {
    // �༭�ֵ�����ʱˢ���ֵ���ֵ����Ĵ�������
    int flushCache() throws SQLException;
}
