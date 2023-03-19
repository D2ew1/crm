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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public ResultDTO login(String loginAct, String loginPwd, String rememberMe, HttpServletRequest request, HttpServletResponse response) throws DBException, LoginException {

        ResultDTO resultDTO = new ResultDTO();
        User user = userServices.login(loginAct, loginPwd);
        request.getSession(true).setAttribute("user", user);

        if (rememberMe != null && rememberMe.equals("1")) {
            // 使用 response指派客户端(浏览器)添加 cookies
            // 创建实例时注意 value只能是 String类型；
            // 注意：由于 UserServices.login()使用的是明文密码，所以 Cookie中也只能存放明文密码；
            Cookie loginActCK = new Cookie("loginAct", loginAct);
            // 设置 cookie作用域
            loginActCK.setPath("/");
            // 设置 cookie存活时间，单位为秒
            loginActCK.setMaxAge(10 * 24 * 60 * 60);
            response.addCookie(loginActCK);

            Cookie loginPwdCK = new Cookie("loginPwd", loginPwd);
            loginPwdCK.setPath("/");
            loginPwdCK.setMaxAge(10 * 24 * 60 * 60);
            response.addCookie(loginPwdCK);
        }

        resultDTO.setResult(Result.success);
        resultDTO.setData(null);
        resultDTO.setMsg("登陆成功");
        return resultDTO;
    }

    @RequestMapping("logout.action")
    public ResultDTO logout(HttpServletRequest request, HttpServletResponse response) {

        ResultDTO resultDTO = new ResultDTO();
        // Cookie中保留失效的 SESSIONID；
        request.getSession(false).invalidate();

        // 同域下 Cookie的 key是唯一的，且采取的是覆盖策略；
        Cookie loginActCK = new Cookie("loginAct", "");
        loginActCK.setPath("/");
        loginActCK.setMaxAge(0);
        response.addCookie(loginActCK);

        Cookie loginPwdCK = new Cookie("loginPwd", "");
        loginPwdCK.setPath("/");
        loginPwdCK.setMaxAge(0);
        response.addCookie(loginPwdCK);

        resultDTO.setResult(Result.success);
        resultDTO.setData(null);
        resultDTO.setMsg("登出成功");
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
