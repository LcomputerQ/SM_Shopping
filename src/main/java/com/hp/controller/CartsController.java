package com.hp.controller;

import com.hp.pojo.Carts;
import com.hp.pojo.Users;
import com.hp.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

    /**
     * 添加购物车商品数量
     * @param id
     * @return
     */
    @PostMapping("cartAdd")
    @ResponseBody
    public int cartAdd(@RequestParam("id") Integer id){
        Carts carts = Carts.builder().id(id).amount(1).build();
        return cartsService.update(carts);
    }

    /**
     * 减少购物车商品数量
     * @param id
     * @return
     */
    @PostMapping("cartLess")
    @ResponseBody
    public int cartLess(@RequestParam("id") Integer id){
        Carts carts = Carts.builder().id(id).amount(-1).build();
        return cartsService.update(carts);
    }

    /**
     * 获取购物车总价
     * @param session
     * @return
     */
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

    /**
     * 删除购物车
     * @param id
     * @return
     */
    @PostMapping("cartDelete")
    @ResponseBody
    public int cartDelete(Integer id){
       return cartsService.cartDelete(id);
    }

    /**
     * 添加到购物车
     * @param goodId
     * @param session
     * @return
     */
    @PostMapping("cartBuy")
    @ResponseBody
    public int cartBuy(Integer goodId,HttpSession session){
        Users user = (Users) session.getAttribute("user");
        Carts carts = Carts.builder().userId(user.getId()).amount(1).goodId(goodId).build();
        if(cartsService.amount(carts)>=1){
            cartsService.update(carts);
            return -1;
        }
        return cartsService.add(carts);
    }

    /**
     * 获取购物车总数
     * @param session
     * @return
     */
    @GetMapping("amount")
    @ResponseBody
    public int amount(HttpSession session){
        Users user = (Users) session.getAttribute("user");
        return cartsService.amount(Carts.builder().userId(user.getId()).build());
    }
}
