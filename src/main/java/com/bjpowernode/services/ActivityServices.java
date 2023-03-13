package com.bjpowernode.services;

import com.bjpowernode.beans.Activity;
import com.bjpowernode.beans.Page;
import com.bjpowernode.exception.DBException;

public interface ActivityServices extends BaseServices<Activity, String> {
    void getPage(Page page) throws DBException;
}
