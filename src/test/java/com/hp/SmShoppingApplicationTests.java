package com.hp;

import com.hp.mapper.GoodsMapper;
import com.hp.mapper.ItemsMapper;
import com.hp.mapper.OrdersMapper;
import com.hp.mapper.TopsMapper;
import com.hp.pojo.Goods;
import com.hp.service.OrdersService;
import com.hp.vo.ItemsVo;
import com.hp.vo.OrderVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SmShoppingApplicationTests {
    @Autowired
   private GoodsMapper goodsMapper;
    @Autowired
    private OrdersService mapper;
    @Test
    void contextLoads() {
//        System.out.println(System.getProperty("user.dir")+"src\\main\\resources\\public");
        List<OrderVo> all = mapper.getAll();
        all.forEach(obj->{
            System.out.println("obj = " + obj);
        });
    }

}
