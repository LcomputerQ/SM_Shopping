package com.hp.controller;

import com.hp.pojo.Users;
import com.hp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/tologin")
    public String login(Users users, HttpSession session, Model model) {
        if (usersService.login(users) == null) {
            model.addAttribute("error", "账号或者密码错误");
            return "/index/login";
        }
        session.setAttribute("user", users);
        return "/index/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "/index/index";
    }
}
