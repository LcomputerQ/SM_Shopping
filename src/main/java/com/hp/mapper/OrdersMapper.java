package com.hp.mapper;

import com.hp.pojo.Orders;
import com.hp.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrdersMapper {
    /**
     * 获取所有的订单
     * @return
     */
    List<OrderVo> getAll(Orders orders);

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
    int delete(@Param("id") Integer id);

    /**
     * 添加订单
     * @param orders
     * @return
     */
    int add(Orders orders);

    /**
     * 获取订单商品已经订单列表
     * @param orders
     * @return
     */
    OrderVo get(@Param("order") Orders orders);
}
