package com.hp.service.impl;

import com.hp.mapper.ItemsMapper;
import com.hp.pojo.Items;
import com.hp.service.ItemsService;
import com.hp.vo.ItemsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsMapper itemsMapper;

    /**
     * 添加订单列表
     *
     * @param items
     * @return
     */
    @Override
    public int add(List<Items> items) {
        return itemsMapper.add(items);
    }
}
