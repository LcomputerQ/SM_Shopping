package com.hp.mapper;

import com.hp.pojo.Carts;
import com.hp.vo.CartsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartsMapper {
    /**
     * 获取所有的购物车列表
     * @return
     */
    List<CartsVo> getAll(Integer uId);

    /**
     * 修改购物车
     * @param carts
     * @return
     */
    int update(Carts carts);

    /**
     * 删除购物车
     * @param id
     * @return
     */
    int cartDelete(Integer id);

    /**
     * 添加购物车
     * @param carts
     * @return
     */
    int add(Carts carts);

    /**
     * 获取购物车数量
     * @param carts
     * @return
     */
    int amount(Carts carts);


}
