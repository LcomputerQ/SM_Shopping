package com.hp.interceptor;

import com.hp.pojo.Admins;
import com.hp.pojo.Users;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String pri = request.getRequestURI().split("/")[1];
        Admins admin = (Admins) request.getSession().getAttribute("admin");
        Users users = (Users) request.getSession().getAttribute("user");
        if(admin==null&&pri.equals("admin")){
            response.sendRedirect("/admin/login");
            return false;
        }
        if (users==null&&pri.equals("index")){
            response.sendRedirect("/index/login");
            return false;
        }
        return true;
    }
}
