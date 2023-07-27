package com.hp.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class UsersException {
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String exceptionHandler(SQLIntegrityConstraintViolationException ex, Model model){
        String message = ex.getMessage();
        return "";
    }

}
