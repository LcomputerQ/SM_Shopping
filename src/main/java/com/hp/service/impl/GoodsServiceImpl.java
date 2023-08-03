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
import java.util.stream.Collectors;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public Map<String,Object> getAll(Integer page,Integer type) {
        int size = 6;
//      开启分页
        PageHelper.startPage(page, size);
        List<GoodVo> all = goodsMapper.getAll(type);
        Page<GoodVo> goods = (Page<GoodVo>) all;
        HashMap<String, Object> map = new HashMap<>();
        map.put("list",goods.getResult());
        map.put("total",goods.getTotal());
        map.put("page",page);
        map.put("numPage",(goods.getTotal()/size)+1);
        map.put("type",type==null?"":type);
        if(goods.getTotal()%size==0)
            map.put("numPage",(goods.getTotal()/size));
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

    @Override
    public GoodVo getById(Integer id) {
        return goodsMapper.getById(id);
    }
    /**
     * 修改商品
     * @param goods
     * @return
     */
    public int update(Goods goods){
        return goodsMapper.update(goods);
    }

    @Override
    public int add(Goods goods) {
        return goodsMapper.add(goods);
    }

    /**
     * 根据类型查找商品
     *
     * @param goods
     * @return
     */
    @Override
    public List<Goods> getGoodsList(Goods goods,Integer page,Integer size) {
        PageHelper.startPage(page,size);
        Page<Goods> pages = (Page<Goods>)goodsMapper.getGoodsList(goods);
        return pages.getResult();
    }

    /**
     * 查询新品
     *
     * @param page
     * @return
     */
    @Override
    public Map<String, Object> newGoods(Integer page) {
        int pageSize = 5;
        PageHelper.startPage(page,pageSize);
        return mapList(goodsMapper.newGoods(),page,pageSize);
    }

    /**
     * 今日推荐
     *
     * @param page
     * @return
     */
    @Override
    public Map<String, Object> todayGoods(Integer page) {
        int pageSize = 5;
        PageHelper.startPage(page,pageSize);

        return mapList(goodsMapper.todayGoods(),page,pageSize);
    }

    /**
     * 销量排名
     *
     * @param page
     * @return
     */
    @Override
    public Map<String, Object> hotGoods(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return mapList(goodsMapper.hotGoods(),page,pageSize);
    }

    /**
     * 根据类目
     *
     * @param page
     * @return
     */
    @Override
    public Map<String, Object> typeGoods(Integer page,Integer typeId) {
        int pageSize = 15;
        PageHelper.startPage(page,pageSize);
        return mapList(goodsMapper.getGoodsList(Goods.builder().typeId(typeId).build()),page,pageSize);
    }

    /**
     * 根据商品名
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> nameGoods(Integer page, Integer pageSize,Goods goods) {
        PageHelper.startPage(page,pageSize);
        return mapList(goodsMapper.getGoodsList(goods),page,pageSize);
    }

    public Map<String,Object> mapList(List<Goods> goodsList,Integer page,Integer pageSize){
        Map<String,Object> map = new HashMap<>();
        Page<Goods> pages = (Page<Goods>) goodsList;
        map.put("page",page);
        map.put("numPage",pages.getTotal()%pageSize==0?pages.getTotal()/pageSize:pages.getTotal()/pageSize+1);
        map.put("goodsList",pages.getResult());
        return map;
    }


}
