package com.hp.controller;

import com.hp.pojo.Users;
import com.hp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/index/tologin")
    public String login(Users users, HttpSession session, Model model) {
        Users user = usersService.login(users);
        if ( user== null) {
            model.addAttribute("error", "账号或者密码错误");
            return "/index/login";
        }
        session.setAttribute("user", user);
        return "redirect:/index/index";
    }

    @GetMapping("/index/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "forward:/index/index";
    }
    @GetMapping("/admin/userList")
    public String userList(HttpSession session,Model model,@RequestParam(defaultValue = "1",name = "page",required = false) Integer page){
        model.addAttribute("userList",usersService.getAll(page));
        session.setAttribute("View", "list");
        session.setAttribute("prefixView", "/admin/user_list");
        return "admin/index";
    }
    @GetMapping("/admin/userAdd")
    public String userAdd(HttpSession session,Model model){
        session.setAttribute("View", "add");
        session.setAttribute("prefixView", "/admin/user_add");
        return "admin/index";
    }
    @GetMapping("/admin/userEdit")
    public String userEdit(HttpSession session,Model model,Integer id){
        session.setAttribute("View", "edit");
        session.setAttribute("prefixView", "/admin/user_edit");
        model.addAttribute("user",usersService.getById(id));
        return "admin/index";
    }
    @PostMapping("/admin/userUpdate")
    public String userUpdate(Users users){
        usersService.update(users);
        return "redirect:/admin/userList";
    }
    @GetMapping("/admin/user_reset")
    public String userReset(Integer id,HttpSession session,Model model,String username){
        model.addAttribute("id",id);
        model.addAttribute("username",username);
        session.setAttribute("View", "reset");
        session.setAttribute("prefixView", "/admin/user_reset");
        return "admin/index";
    }
    @PostMapping("/admin/userReset")
    public String userReset(Users users){
        usersService.update(users);
        return "redirect:/admin/userList";
    }
    @PostMapping("/admin/userSave")
    public String userSave(Users users){
        usersService.save(users);
        return "redirect:/admin/userList";
    }
    @GetMapping("admin/userDelete")
    public String userDelete(Integer id){
        usersService.delete(id);
        return "forward:/admin/userList";
    }
}
