package com.hp.interceptor;

import com.hp.pojo.Admins;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Admins admin = (Admins) request.getSession().getAttribute("admin");
        if(admin==null){
            response.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }
}
