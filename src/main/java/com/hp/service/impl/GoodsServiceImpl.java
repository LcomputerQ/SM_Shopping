package com.hp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hp.mapper.GoodsMapper;
import com.hp.pojo.Goods;
import com.hp.service.GoodsService;
import com.hp.vo.GoodVo;
import javafx.util.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public Map<String,Object> getAll(Integer page) {
//      开启分页
        PageHelper.startPage(page, 5);
        List<GoodVo> all = goodsMapper.getAll();
        Page<GoodVo> goods = (Page<GoodVo>) all;
        HashMap<String, Object> map = new HashMap<>();
        map.put("list",goods.getResult());
        map.put("total",goods.getTotal());
        map.put("page",page);
        map.put("numPage",(goods.getTotal()/5)+1);
        if(goods.getTotal()%5==0)
            map.put("numPage",(goods.getTotal()/5));
        return map;
    }
    /**
     * 删除商品
     * @param id
     * @return
     */
    @Override
    public int goodDelete(Integer id) {
        return goodsMapper.delete(id);
    }
}
