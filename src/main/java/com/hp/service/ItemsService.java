package com.hp.service;

import com.hp.pojo.Items;
import com.hp.vo.ItemsVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemsService {
    /**
     * 添加订单列表
     * @param items
     * @return
     */
    int add(@Param("items") List<Items> items);

    /**
     * 删除订单列表
     * @param orderId
     * @return
     */
    int delete(Integer orderId);

}
