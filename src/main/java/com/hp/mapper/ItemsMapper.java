package com.hp.mapper;

import com.hp.pojo.Items;
import com.hp.vo.ItemsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemsMapper {
    /**
     * 根据订单列表查看订单
     * @return
     */
    List<ItemsVo> getOrderId(Integer orderId);

    /**
     * 删除订单列表
     * @param orderId
     * @return
     */
    int delete(Integer orderId);

    /**
     * 添加订单列表
     * @param items
     * @return
     */
    int add(@Param("items") List<Items> items);
}
