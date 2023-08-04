package com.hp.controller;

import com.hp.pojo.Tops;
import com.hp.pojo.Types;
import com.hp.service.TopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class TopsController {
    @Autowired
    private TopsService topsService;
    @GetMapping("topSave")
    public String addTops(Integer goodId, HttpSession session){
       topsService.addTops(Tops.builder().goodId(goodId).type(1).build());
       return "forward:/admin/goodList?page="+session.getAttribute("goodsPage")+"&type="+session.getAttribute("goodsType");
    }
    @GetMapping("deleteTops")
    public String deleteTops(Integer goodId,HttpSession session){
        topsService.deleteTops(goodId);
        return "forward:/admin/goodList?page="+session.getAttribute("goodsPage")+"&type="+session.getAttribute("goodsType");
    }
}
