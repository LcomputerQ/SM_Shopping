package com.hp.controller;

import com.hp.pojo.Carts;
import com.hp.pojo.Users;
import com.hp.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("index")
public class CartsController {
    @Autowired
    private CartsService cartsService;
    @GetMapping("cart")
    public String indexCart(Model model,HttpSession session){
        Users user = (Users) session.getAttribute("user");
        model.addAttribute("cart",cartsService.getAll(user.getId()));
     return "index/cart";
    }
    @PostMapping("cartAdd")
    @ResponseBody
    public int cartAdd(@RequestParam("id") Integer id){
        Carts carts = Carts.builder().id(id).amount(1).build();
        return cartsService.update(carts);
    }
    @PostMapping("cartLess")
    @ResponseBody
    public int cartLess(@RequestParam("id") Integer id){
        Carts carts = Carts.builder().id(id).amount(-1).build();
        return cartsService.update(carts);
    }
    @GetMapping("cartTotal")
    @ResponseBody
    public AtomicInteger cartTotal(HttpSession session){
        AtomicInteger num = new AtomicInteger();
        Users user = (Users) session.getAttribute("user");
        cartsService.getAll(user.getId()).forEach(cartsVo -> {
            num.addAndGet(cartsVo.getCarts().getAmount() * cartsVo.getGoods().getPrice());
        });
        return num;
    }
    @PostMapping("cartDelete")
    @ResponseBody
    public int cartDelete(Integer id){
       return cartsService.cartDelete(id);
    }
}
