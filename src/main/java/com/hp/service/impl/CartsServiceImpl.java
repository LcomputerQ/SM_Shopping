package com.hp.service.impl;

import com.hp.mapper.CartsMapper;
import com.hp.pojo.Carts;
import com.hp.service.CartsService;
import com.hp.vo.CartsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartsServiceImpl implements CartsService {
    @Autowired
    private CartsMapper cartsMapper;
    /**
     * 获取所有的购物车列表
     *
     * @return
     */
    @Override
    public List<CartsVo> getAll(Integer uId) {
        return cartsMapper.getAll(uId);
    }

    /**
     * 修改购物车
     *
     * @param carts
     * @return
     */
    @Override
    public int update(Carts carts) {
        return cartsMapper.update(carts);
    }

    /**
     * 删除购物车
     *
     * @param id
     * @return
     */
    @Override
    public int cartDelete(Integer id) {
        return cartsMapper.cartDelete(id);
    }

    /**
     * 添加购物车
     *
     * @param carts
     * @return
     */
    @Override
    public int add(Carts carts) {
        return cartsMapper.add(carts);
    }
}
