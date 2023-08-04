package com.hp.controller;
import com.hp.pojo.Goods;
import com.hp.service.GoodsService;
import com.hp.service.TypesService;
import com.hp.utlis.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private TypesService typesService;

    @GetMapping("goodList")
    public String getGoodsList(Model model, HttpSession session,@RequestParam(name = "page",defaultValue = "1",required = false) Integer page,Integer type) {
        model.addAttribute("map", goodsService.getAll(page,type));
        session.setAttribute("View", "goodsList");
        session.setAttribute("prefixView", "admin/good_list");
        session.setAttribute("goodsPage",page);
        session.setAttribute("goodsType",type!=null?type:"");
        return "admin/index";
    }

    @GetMapping("/goodDelete")
    public String goodDelete(Integer id,HttpSession session) {
        int flag = goodsService.goodDelete(id);
        return "forward:/admin/goodList?page="+session.getAttribute("goodsPage")+"&type="+session.getAttribute("goodsType");
    }
    @GetMapping("/goodEdit")
    public String goodEdit(Integer id, Model model,HttpSession session) {
        model.addAttribute("goods", goodsService.getById(id));
        model.addAttribute("types",typesService.getAll());
        session.setAttribute("View", "edit");
        session.setAttribute("prefixView", "admin/good_edit");
        return "admin/index";
    }
    @PostMapping("goodUpdate")
    public String goodUpdate( MultipartFile file, HttpSession session, Goods goods) throws IOException {
        String img = Upload.onUpload(file, session, "upload");
        if(img!=null)
            goods.setCover(img);
        goodsService.update(goods);
        return "redirect:/admin/goodList?page="+session.getAttribute("goodsPage")+"&type="+session.getAttribute("goodsType");
    }
    @GetMapping("goodAdd")
    public String goodAdd(HttpSession session,Model model){
        model.addAttribute("types",typesService.getAll());
        session.setAttribute("View", "add");
        session.setAttribute("prefixView", "admin/good_add");
        return "admin/index";
    }
    @PostMapping("goodSave")
    public String save(Goods goods,MultipartFile file,HttpSession session) throws IOException {
        String img = Upload.onUpload(file, session, "upload");
        goods.setCover(img);
        goods.setSales(0);
        int add = goodsService.add(goods);
        return "redirect:/admin/goodList?page="+session.getAttribute("goodsPage")+"&type="+session.getAttribute("goodsType");
    }

}
