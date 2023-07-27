package com.hp;

import com.hp.mapper.GoodsMapper;
import com.hp.pojo.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SmShoppingApplicationTests {
    @Autowired
   private GoodsMapper goodsMapper;

    @Test
    void contextLoads() {
        List<Goods> all = goodsMapper.getAll();
        for (int is = 0; is < all.size(); is++) {
            System.out.println(all.get(is));
        }
    }

}
