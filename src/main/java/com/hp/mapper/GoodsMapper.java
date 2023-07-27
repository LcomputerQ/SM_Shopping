package com.hp.mapper;

import com.hp.pojo.Goods;
import com.hp.vo.GoodVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    /**
     * 查看所有商品
     * @return
     */
    List<GoodVo> getAll();

    /**
     * 删除商品
     * @param id
     * @return
     */
    int delete(Integer id);
}
