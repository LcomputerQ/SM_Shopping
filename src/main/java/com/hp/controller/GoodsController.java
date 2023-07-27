package com.hp.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hp.pojo.Goods;
import com.hp.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping("goodList")
    public String getGoodsList(Model model, HttpSession session,Integer page){
        if(page==null)page = 1;
         model.addAttribute("map", goodsService.getAll(page));
         session.setAttribute("View", "goodsList");
         session.setAttribute("prefixView", "/admin/good_list");
         return "admin/index";
    }
    @GetMapping("/goodDelete")
    public String goodDelete(Integer id){
        int flag = goodsService.goodDelete(id);
        return "forward:/admin/goodList";
    }
//    @GetMapping("")
}
