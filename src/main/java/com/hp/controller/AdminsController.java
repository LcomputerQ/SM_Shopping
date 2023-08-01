package com.hp.controller;

import com.hp.pojo.Admins;
import com.hp.service.AdminsService;
import com.hp.utlis.Result;
import com.hp.utlis.Safe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminsController {
    @Autowired
    private AdminsService adminsService;
    @PostMapping("/tologin")
    public String login(Admins admins, Model model, HttpSession session, RedirectAttributes redirectAttributes){
//        md5加密
        admins.setPassword(Safe.md5(admins.getPassword()));
        Admins login = adminsService.login(admins);
        if(login==null){
            model.addAttribute("error","账号或者密码错误");
            return "/admin/login";
        }
        session.setAttribute("admin",admins);
        redirectAttributes.addFlashAttribute("msg","登入成功");
        return "redirect:/admin/typeList";
    }
    @GetMapping("adminList")
    public String adminList(HttpSession session,Model model,Integer page){
        if(page==null) page = 1;
        session.setAttribute("View", "list");
        session.setAttribute("prefixView", "/admin/admin_list");
        model.addAttribute("res", adminsService.selectAll(page));
        return "forward:/admin/index";
    }
    @GetMapping("admin_reset")
    public String adminReset(HttpSession session,Model model,Admins admins){
        session.setAttribute("View", "reset");
        session.setAttribute("prefixView", "/admin/admin_reset");
        model.addAttribute("admins",admins);
        return "forward:/admin/index";
    }
    @PostMapping("adminReset")
    public String updateAdmins(Admins admins,Model model){
        int flag = adminsService.update(admins);
        if(flag==1){
            return "redirect:/admin/adminList";
        }
        model.addAttribute("error","修改失败");
        return "forward:/admin/admin_reset";
    }
    @GetMapping("adminDelete")
    public String adminDelete(@RequestParam("id") Integer id){
           adminsService.delete(id);
           return "forward:/admin/adminList";
    }
    @GetMapping("admin_add")
    public String adminAdd(HttpSession session){
        session.setAttribute("View", "add");
        session.setAttribute("prefixView", "/admin/admin_add");
        return "forward:/admin/index";
    }
    @PostMapping("adminSave")
    public String save(Admins admins){
        adminsService.inset(admins);
        return "redirect:/admin/adminList";
    }
    @GetMapping("logout")
    public String logOut(HttpSession session){
        session.removeAttribute("admin");
        return "admin/login";
    }
}
