package com.bjpowernode.filter;

import com.bjpowernode.beans.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        if (requestURI.equals("/login.html")) {
            chain.doFilter(req, res);
        } else {
            HttpSession httpSession = req.getSession(false);
            if (httpSession != null) {
                User user = (User) httpSession.getAttribute("user");
                if (user != null) {
                    chain.doFilter(req, res);
                }
            }
            res.sendRedirect("/login.html");
        }

    }
}
