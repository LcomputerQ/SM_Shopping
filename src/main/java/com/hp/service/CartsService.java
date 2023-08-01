package com.hp.service;

import com.hp.pojo.Carts;
import com.hp.vo.CartsVo;

import java.util.List;

public interface CartsService {
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
}
