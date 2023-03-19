package com.bjpowernode.interceptor;

import com.bjpowernode.beans.User;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.exception.LoginException;
import com.bjpowernode.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * �Զ���������
 *
 * @author Dee
 * @date 2023-03-06 15:44
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserServices userServices;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle:" + request.getRequestURI());

        // ����Ϊ false����Ϊȷ��ֻ���û�����ʱ������ Session������������ڴ汻����ռ�ã�
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            return true;
        } else {
            String loginAct = "";
            boolean loginActFlag = false;
            String loginPwd = "";
            boolean loginPwdFlag = false;

            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("loginAct")) {
                    loginAct = cookie.getValue();
                    loginActFlag = true;
                }
                if (cookie.getName().equals("loginPwd")) {
                    loginPwd = cookie.getValue();
                    loginPwdFlag = true;
                }
            }

            if (loginActFlag && loginPwdFlag) {
                User login = userServices.login(loginAct, loginPwd);
                request.getSession(true).setAttribute("user", login);
                return true;
            } else {
                throw new LoginException("���¼");
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle:" + request.getRequestURI());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion:" + request.getRequestURI());
    }
}
