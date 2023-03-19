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
            // ʹ�� responseָ�ɿͻ���(�����)��� cookies
            // ����ʵ��ʱע�� valueֻ���� String���ͣ�
            // ע�⣺���� UserServices.login()ʹ�õ����������룬���� Cookie��Ҳֻ�ܴ���������룻
            Cookie loginActCK = new Cookie("loginAct", loginAct);
            // ���� cookie������
            loginActCK.setPath("/");
            // ���� cookie���ʱ�䣬��λΪ��
            loginActCK.setMaxAge(10 * 24 * 60 * 60);
            response.addCookie(loginActCK);

            Cookie loginPwdCK = new Cookie("loginPwd", loginPwd);
            loginPwdCK.setPath("/");
            loginPwdCK.setMaxAge(10 * 24 * 60 * 60);
            response.addCookie(loginPwdCK);
        }

        resultDTO.setResult(Result.success);
        resultDTO.setData(null);
        resultDTO.setMsg("��½�ɹ�");
        return resultDTO;
    }

    @RequestMapping("logout.action")
    public ResultDTO logout(HttpServletRequest request, HttpServletResponse response) {

        ResultDTO resultDTO = new ResultDTO();
        // Cookie�б���ʧЧ�� SESSIONID��
        request.getSession(false).invalidate();

        // ͬ���� Cookie�� key��Ψһ�ģ��Ҳ�ȡ���Ǹ��ǲ��ԣ�
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
        resultDTO.setMsg("�ǳ��ɹ�");
        return resultDTO;
    }

    @RequestMapping("getAll.action")
    public ResultDTO getAll() throws DBException, LoginException {

        ResultDTO resultDTO = new ResultDTO();
        ArrayList<User> users = userServices.getAll();
        resultDTO.setResult(Result.success);
        resultDTO.setData(users);
        resultDTO.setMsg("��ѯ�ɹ�");
        return resultDTO;
    }
}
