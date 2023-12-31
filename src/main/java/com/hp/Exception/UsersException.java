package com.hp.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class UsersException {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public void exceptionHandler(SQLIntegrityConstraintViolationException ex, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if(requestURI.split("/")[1].equals("admin")){
            request.getSession().setAttribute("msg","账号已存在添加失败");
            response.sendRedirect("/admin/userAdd");
        }
        if(requestURI.split("/")[1].equals("index")){
            request.getSession().setAttribute("msg","账号已存在注册失败");
            response.sendRedirect("/index/register");
        }
        return;
    }
    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception ex, HttpServletResponse response){
        try {
            response.sendRedirect("/index/error");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return;
    }

}
