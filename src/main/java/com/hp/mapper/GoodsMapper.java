package com.hp.mapper;

import com.hp.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    /**
     * 查看所有商品
     * @return
     */
    List<Goods> getAll();
}
