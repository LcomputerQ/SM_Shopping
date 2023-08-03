package com.hp.controller;

import com.hp.pojo.Goods;
import com.hp.service.GoodsService;
import com.hp.utlis.ListFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static com.hp.utlis.ListFilter.filter;


@Controller
@RequestMapping("index")
public class IndexController {
    @Autowired
    private GoodsService goodsService;
//    首页
    @GetMapping("index")
    public String index(Model model, HttpSession session){
        session.setAttribute("home",0);
        model.addAttribute("today",goodsService.getAll(1,1).get("list"));
        Goods goods = Goods.builder().sales(0).build();
        model.addAttribute("sales",goodsService.getGoodsList(goods, 1,8));
        goods.setSales(null);
//        果蔬
        goods.setTypeId(1);
        model.addAttribute("fruit",filter(goodsService.getGoodsList(goods, 1, 25)));
//        肉类
        goods.setTypeId(2);
        model.addAttribute("meat",filter(goodsService.getGoodsList(goods, 1, 25)));
//        米面
        goods.setTypeId(3);
        model.addAttribute("rice",filter(goodsService.getGoodsList(goods, 1, 25)));
//        零食
        goods.setTypeId(4);
        model.addAttribute("snacks",filter(goodsService.getGoodsList(goods, 1, 25)));
        goods.setTypeId(5);
        model.addAttribute("toy",filter(goodsService.getGoodsList(goods,1,25)));
        goods.setTypeId(6);
        model.addAttribute("outdoors",filter(goodsService.getGoodsList(goods,1,25)));
        return "index/index";
    }
//    今日推荐
    @GetMapping("today")
    public String today(Model model,HttpSession session,@RequestParam(name = "page",defaultValue = "1",required = false) Integer page){
        session.setAttribute("home",1);
        model.addAttribute("href","today");
        model.addAttribute("goods",goodsService.todayGoods(page));
        return "index/goods";
    }

    /**
     * 热门商品
     * @param model
     * @param session
     * @return
     */
    @GetMapping("hot")
    public String hot(Model model,HttpSession session,@RequestParam(name = "page",defaultValue = "1",required = false) Integer page){
        session.setAttribute("home",2);
        model.addAttribute("href","hot");
        model.addAttribute("goods",goodsService.hotGoods(page,5));
        return "index/goods";
    }

    /**
     * 新品上市
     * @param model
     * @param session
     * @return
     */
    @GetMapping("new")
    public String newGoods(Model model ,HttpSession session,@RequestParam(name = "page",defaultValue = "1",required = false) Integer page){
        session.setAttribute("home",3);
        model.addAttribute("href","new");
        model.addAttribute("goods",goodsService.newGoods(page));
        return "index/goods";
    }
//    商品分类
    @GetMapping("type")
    public String typeGoods(Model model,HttpSession session,Integer id,@RequestParam(name = "page",defaultValue = "1",required = false) Integer page){
        session.setAttribute("home",0);
        model.addAttribute("href","type");
        model.addAttribute("id",id);
        model.addAttribute("goods",goodsService.typeGoods(page,id));
        return "index/goods";
    }


    /**
     * 查看详细商品
     * @param id
     * @param model
     * @return
     */
    @GetMapping("detail")
    public String detail(Integer id,Model model){
        model.addAttribute("goodsVo",goodsService.getById(id));
        model.addAttribute("goods",goodsService.hotGoods(1,2));
        return "/index/detail";
    }
    @GetMapping("search")
    public String search(Model model,HttpSession session,String name,@RequestParam(name = "page",defaultValue = "1",required = false) Integer page){
        model.addAttribute("href","search");
        model.addAttribute("name",name);
        model.addAttribute("goods",goodsService.nameGoods(page,5,Goods.builder().name(name).build()));
        return "index/goods";
    }
}
