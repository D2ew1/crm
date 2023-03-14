package com.bjpowernode.controller;

import com.bjpowernode.beans.User;
import com.bjpowernode.dto.Page;
import com.bjpowernode.dto.Result;
import com.bjpowernode.dto.ResultDTO;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Dee
 * @date 2023-03-10 09:24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @RequestMapping("getAll.action")
    public ResultDTO getAll() throws DBException {

        ResultDTO resultDTO = new ResultDTO();
        ArrayList<User> users = userServices.getAll();
        resultDTO.setResult(Result.success);
        resultDTO.setData(users);
        resultDTO.setMsg("≤È—Ø≥…π¶");
        return resultDTO;
    }
}
