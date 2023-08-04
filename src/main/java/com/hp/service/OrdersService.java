package com.hp.service;

import com.hp.pojo.Orders;
import com.hp.vo.OrderVo;

import java.util.List;
import java.util.Map;

public interface OrdersService {
    /**
     * 获取所有的订单
     * @return
     */
    Map<String,Object> getAll(Orders orders,Integer page);
    /**
     * 修改订单
     * @param orders
     * @return
     */
    int update(Orders orders);
    /**
     * 删除订单
     * @param id
     * @return
     */
    int delete(Integer id);
    /**
     * 添加订单
     * @param orders
     * @return
     */
    int add(Orders orders);

    /**
     * 修改商品库存和商品销售
     * @param orders
     * @return
     */
    void updateGoodSales(Orders orders);
    /**
     * 获取订单商品已经订单列表
     * @param orders
     * @return
     */
    OrderVo get(Orders orders);
}
