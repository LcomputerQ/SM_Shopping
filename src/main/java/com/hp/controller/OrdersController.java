package com.hp.controller;
import com.hp.pojo.Items;
import com.hp.pojo.Orders;
import com.hp.pojo.Users;
import com.hp.service.CartsService;
import com.hp.service.ItemsService;
import com.hp.service.OrdersService;
import com.hp.vo.CartsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private CartsService cartsService;
    @Autowired
    private ItemsService itemsService;
    @GetMapping("/admin/orderList")
    public String getAll(HttpSession session, Model model, Orders orders,@RequestParam(defaultValue = "1",required = false,name = "page") Integer page){
        model.addAttribute("orderList",ordersService.getAll(orders,page));
        session.setAttribute("View", "list");
        session.setAttribute("prefixView", "/admin/order_list");
        return "admin/index";
    }
    @GetMapping("/admin/orderUpdate")
    public String orderUpdate(Orders orders){
       ordersService.update(orders);
       return "forward:/admin/orderList";
    }
    @GetMapping("/admin/orderDelete")
    public String orderDelete(Integer id){
        ordersService.delete(id);
        return "forward:/admin/orderList";
    }
    @GetMapping("/index/order")
    public String indexOrder(Model model,HttpSession session,@RequestParam(defaultValue = "1",required = false,name = "page") Integer page){
        Users user = (Users) session.getAttribute("user");
        model.addAttribute("orders",ordersService.getAll(Orders.builder().userId(user.getId()).build(),page));
        return "/index/order";
    }
    @GetMapping("index/orderSave")
    @Transactional
    public String orderSave(HttpSession session,Model model){
        Users user = (Users) session.getAttribute("user");
        List<CartsVo> cartsVoList = cartsService.getAll(user.getId());
        model.addAttribute("CartsVo",cartsVoList);
        double total = 0.0;
        List<Items> items = new ArrayList<>();
        for (int i = 0; i < cartsVoList.size(); i++) {
            total += cartsVoList.get(i).getCarts().getAmount()*cartsVoList.get(i).getGoods().getPrice();
        }
        model.addAttribute("total",total);

        Orders orders = Orders.builder().userId(user.getId()).amount(new Double(cartsVoList.size())).address(user.getAddress()).total(total).status(1).phone(user.getPhone()).build();
        ordersService.add(orders);
        model.addAttribute("goodId",orders.getId());
        for (int i = 0; i < cartsVoList.size(); i++) {
            items.add(Items.builder().price(cartsVoList.get(i).getGoods().getPrice()).amount(cartsVoList.get(i).getCarts().getAmount()).goodId(cartsVoList.get(i).getGoods().getId()).orderId(orders.getId()).build());
            cartsService.cartDelete(cartsVoList.get(i).getCarts().getId());
        }
        itemsService.add(items);
        return "/index/pay";
    }
    @PostMapping("/index/orderPay")
    public String orderPay(Orders orders){
        ordersService.update(orders);
        return null;
    }

}
