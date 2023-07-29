package com.hp.controller;
import com.hp.pojo.Orders;
import com.hp.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @GetMapping("orderList")
    public String getAll(HttpSession session, Model model, Orders orders,@RequestParam(defaultValue = "1",required = false,name = "page") Integer page){
        model.addAttribute("orderList",ordersService.getAll(orders,page));
        session.setAttribute("View", "list");
        session.setAttribute("prefixView", "/admin/order_list");
        return "admin/index";
    }
    @GetMapping("orderUpdate")
    public String orderUpdate(Orders orders){
       ordersService.update(orders);
       return "forward:/admin/orderList";
    }
    @GetMapping("orderDelete")
    public String orderDelete(Integer id){
        ordersService.delete(id);
        return "forward:/admin/orderList";
    }

}
