package com.hp.mapper;

import com.hp.vo.ItemsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemsMapper {
    /**
     * 根据订单列表查看订单
     * @return
     */
    List<ItemsVo> getOrderId(Integer orderId);
}
