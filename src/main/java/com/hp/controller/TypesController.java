package com.hp.controller;

import com.hp.pojo.Types;
import com.hp.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class TypesController {
    @Autowired
    private TypesService typesService;

    @GetMapping("/redirect/type_add")
    public String redirectTypeAdd(HttpSession session) {
        session.setAttribute("View", "type_add");
        session.setAttribute("prefixView", "admin/type_add");
        return "redirect:/admin/index";
    }

    @GetMapping("/typeList")
    public String getTypesAll(Model model, HttpSession session) {
        model.addAttribute("typeList", typesService.getAll());
        session.setAttribute("View", "list");
        session.setAttribute("prefixView", "admin/type_list");
        return "admin/index";
    }

    @GetMapping("typeDelete")
    public String typeDelete(RedirectAttributes model, Integer id) {
        int flag = typesService.deleteTypes(id);
        if (flag == 1) {
            model.addFlashAttribute("msg", "删除成功");
        } else {
            model.addFlashAttribute("msg", "删除失败");
        }
        return "forward:/admin/typeList";
    }

    @PostMapping("typeSave")
    public String typeSave(Types types, RedirectAttributes model) {
        int flag = typesService.addTypes(types);
        if (flag == 1) {
            model.addFlashAttribute("msg", "添加成功");
        } else {
            model.addFlashAttribute("msg", "添加失败");
        }
        return "redirect:/admin/typeList";
    }

    @PostMapping("typeUpdate")
    public String typeUpdate(Types types,HttpSession session) {
        typesService.updateTypes(types);
        return "redirect:/admin/typeList";
    }

    @GetMapping("typeEdit")
    public String get(Integer id, Model model, HttpSession session) {
        session.setAttribute("View", "edit");
        session.setAttribute("prefixView", "admin/type_edit");
        model.addAttribute("types", typesService.getById(id));
        return "admin/index";
    }
}
