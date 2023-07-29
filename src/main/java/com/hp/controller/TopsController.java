package com.hp.controller;

import com.hp.pojo.Tops;
import com.hp.pojo.Types;
import com.hp.service.TopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class TopsController {
    @Autowired
    private TopsService topsService;
    @GetMapping("addTops")
    public String addTops(Integer goodId){
       topsService.addTops(Tops.builder().goodId(goodId).type(1).build());
       return "forward:/admin/goodList";
    }
    @GetMapping("deleteTops")
    public String deleteTops(Integer goodId){
        topsService.deleteTops(goodId);
        return "forward:/admin/goodList";
    }
}
