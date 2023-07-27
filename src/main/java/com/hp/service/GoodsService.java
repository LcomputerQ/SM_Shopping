package com.hp.service;

import com.hp.pojo.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    /**
     * 查看所有商品
     * @return
     */
    Map<String,Object> getAll(Integer page);
}
