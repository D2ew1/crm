package com.bjpowernode.controller;

import com.bjpowernode.beans.User;
import com.bjpowernode.dto.Page;
import com.bjpowernode.dto.Result;
import com.bjpowernode.dto.ResultDTO;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.exception.LoginException;
import com.bjpowernode.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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

    @RequestMapping("login.action")
    public ResultDTO login(String loginAct, String loginPwd, HttpSession httpSession) throws DBException, LoginException {

        ResultDTO resultDTO = new ResultDTO();
        User user = userServices.login(loginAct, loginPwd);
        httpSession.setAttribute("user", user);
        resultDTO.setResult(Result.success);
        resultDTO.setData(null);
        resultDTO.setMsg("登陆成功");
        return resultDTO;
    }

    @RequestMapping("getAll.action")
    public ResultDTO getAll() throws DBException, LoginException {

        ResultDTO resultDTO = new ResultDTO();
        ArrayList<User> users = userServices.getAll();
        resultDTO.setResult(Result.success);
        resultDTO.setData(users);
        resultDTO.setMsg("查询成功");
        return resultDTO;
    }
}
