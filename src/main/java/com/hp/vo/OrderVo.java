package com.hp.vo;

import com.hp.pojo.Orders;
import com.hp.pojo.Users;
import lombok.Data;

import java.util.List;

@Data
public class OrderVo {
    private Orders orders;
    private Users users;
    private List<ItemsVo> itemsVo;
}
