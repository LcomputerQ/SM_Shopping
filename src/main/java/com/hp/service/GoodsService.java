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
    /**
     * 根据类型查找商品
     * @param goods
     * @return
     */
    List<Goods> getGoodsList(Goods goods,Integer page,Integer pageSize);
    /**
     * 查询新品
     * @return
     */
    Map<String,Object> newGoods(Integer page);

    /**
     * 今日推荐
     * @param page
     * @return
     */
    Map<String,Object> todayGoods(Integer page);
    /**
     * 销量排名
     * @param page
     * @return
     */
    Map<String,Object> hotGoods(Integer page,Integer size);

    /**
     * 根据类目
     * @param page
     * @return
     */
    Map<String,Object> typeGoods(Integer page,Integer typeId);

    /**
     * 根据商品名
     * @param page
     * @param pageSize
     * @return
     */
    Map<String,Object> nameGoods(Integer page,Integer pageSize,Goods goods);

}
