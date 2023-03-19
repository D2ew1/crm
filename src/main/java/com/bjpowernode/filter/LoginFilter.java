package com.bjpowernode.filter;

import com.bjpowernode.beans.User;
import com.bjpowernode.exception.DBException;
import com.bjpowernode.exception.LoginException;
import com.bjpowernode.services.UserServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Dee
 * @date 2023-03-17 15:44
 */
@WebFilter(urlPatterns = "*.html")
public class LoginFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String requestURI = req.getRequestURI();
        System.out.println("doFilter:" + requestURI);

        if (requestURI.equals("/") || requestURI.equals("/login.html")) {
            chain.doFilter(req, res);
        } else {
            HttpSession session = req.getSession(false);
            if (session != null && session.getAttribute("user") != null) {
                chain.doFilter(req, res);
            } else {
                String loginAct = "";
                boolean loginActFlag = false;
                String loginPwd = "";
                boolean loginPwdFlag = false;

                Cookie[] cookies = req.getCookies();
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
                    // 由于 UserServices实现类已交由 Spring管理，所以应通过 Spring获取其实现类实例；
                    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                    // 由于 UserServices只有一个实现类，所以可以直接用接口类型(单参)获取其实现类实例；
                    UserServices userServices = context.getBean(UserServices.class);
                    // 由于 Filter并不基于 SpringMVC，所以抛出的异常无法由全局异常处理器接收；
                    User login = null;
                    try {
                        login = userServices.login(loginAct, loginPwd);
                    } catch (DBException | LoginException ex) {
                        res.sendRedirect("/login.html");
                        return;
                    }
                    req.getSession(true).setAttribute("user", login);
                    chain.doFilter(req, res);
                }
                res.sendRedirect("/login.html");
            }
        }
    }
}
