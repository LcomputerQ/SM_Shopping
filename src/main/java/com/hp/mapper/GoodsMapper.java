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
    List<GoodVo> getAll(Integer type);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int delete(Integer id);

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
    Goods get(Integer id);

    /**
     * 根据类型查找商品
     * @param goods
     * @return
     */
    List<Goods> getGoodsList(Goods goods);

    /**
     * 查询新品
     * @return
     */
    List<Goods> newGoods();
    /**
     * 查询今日推荐商品
     */
    List<Goods> todayGoods();

    /**
     * 销量最高
     * @return
     */
    List<Goods> hotGoods();
}
