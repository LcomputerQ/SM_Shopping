package com.hp.service;

import com.hp.pojo.Goods;
import com.hp.vo.GoodVo;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    /**
     * 查看所有商品
     * @return
     */
    Map<String,Object> getAll(Integer page,Integer type);
    /**
     * 删除商品
     * @param id
     * @return
     */
    int goodDelete(Integer id);
    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    GoodVo getById(Integer id);
    /**
     * 修改商品
     * @param goods
     * @return
     */
    int update(Goods goods);
    /**
     * 添加商品
     * @param goods
     * @return
     */
    int add(Goods goods);
}
