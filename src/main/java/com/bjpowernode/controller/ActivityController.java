package com.bjpowernode.controller;

import com.bjpowernode.beans.Activity;
import com.bjpowernode.beans.Page;
import com.bjpowernode.dto.Result;
import com.bjpowernode.dto.ResultDTO;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.exception.InputException;
import com.bjpowernode.services.ActivityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Dee
 * @date 2023-03-09 21:02
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    ActivityServices activityServices;

    @RequestMapping("getPage.action")
    public ResultDTO getPage(@RequestBody Page page) throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        activityServices.getPage(page);
        resultDTO.setResult(Result.success);
        resultDTO.setData(page);
        resultDTO.setMsg("查询成功");
        return resultDTO;
    }

    @RequestMapping("get.action")
    public ResultDTO get(String id) throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        Activity activity = activityServices.get(id);
        resultDTO.setResult(Result.success);
        resultDTO.setData(activity);
        resultDTO.setMsg("查询成功");
        return resultDTO;
    }

    @RequestMapping("add.action")
    public ResultDTO add(Activity activity) throws DBException, InputException {

        ResultDTO resultDTO = new ResultDTO();
        activityServices.add(activity);
        resultDTO.setResult(Result.success);
        resultDTO.setData(null);
        resultDTO.setMsg("添加成功");
        return resultDTO;
    }

    @RequestMapping("del.action")
    public ResultDTO del(@RequestBody String[] ids) throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        activityServices.del(ids);
        resultDTO.setResult(Result.success);
        resultDTO.setData(null);
        resultDTO.setMsg("删除成功");
        return resultDTO;
    }
}
