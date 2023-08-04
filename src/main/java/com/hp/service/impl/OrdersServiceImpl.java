package com.hp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hp.mapper.GoodsMapper;
import com.hp.mapper.ItemsMapper;
import com.hp.mapper.OrdersMapper;
import com.hp.pojo.Goods;
import com.hp.pojo.Orders;
import com.hp.service.OrdersService;
import com.hp.vo.ItemsVo;
import com.hp.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    /**
     * 获取所有的订单
     *
     * @return
     */
    @Override
    public Map<String,Object> getAll(Orders orders,Integer page) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(page,5);
        List<OrderVo> orderVoList = ordersMapper.getAll(orders);
        Page<OrderVo> pages = (Page<OrderVo>) orderVoList;
        map.put("orderVoList",pages.getResult());
        map.put("page",page);
        map.put("total",pages.getTotal());
        map.put("status",orders.getStatus()!=null?orders.getStatus():"");
        map.put("numPage",pages.getTotal()%5==0?pages.getTotal()/5:pages.getTotal()/5+1);
        return map;
    }

    /**
     * 修改订单
     *
     * @param orders
     * @return
     */
    @Override
    public int update(Orders orders) {
        return ordersMapper.update(orders);
    }

    /**
     * 删除订单
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public int delete(Integer id) {
        itemsMapper.delete(id);
        return ordersMapper.delete(id);
    }

    /**
     * 添加订单
     *
     * @param orders
     * @return
     */
    @Override
    public int add(Orders orders) {

        return ordersMapper.add(orders);
    }

    /**
     * 修改商品库存和商品销售
     *
     * @param orders
     * @return
     */
    @Override
    @Transactional
    public void updateGoodSales(Orders orders) {
        OrderVo orderVo = ordersMapper.get(orders);
        List<ItemsVo> itemsVo = orderVo.getItemsVo();
        for (int i = 0; i < itemsVo.size(); i++) {
            ItemsVo items= itemsVo.get(i);
            goodsMapper.updateStock(Goods.builder().sales(items.getItems().getAmount()).stock(items.getItems().getAmount()).id(items.getItems().getGoodId()).build());
        }
    }

    /**
     * 获取订单商品已经订单列表
     *
     * @param orders
     * @return
     */
    @Override
    public OrderVo get(Orders orders) {
        return ordersMapper.get(orders);
    }
}
