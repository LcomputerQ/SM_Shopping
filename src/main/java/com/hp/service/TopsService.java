package com.hp.service;

import com.hp.pojo.Tops;

public interface TopsService {
    /**
     * 添加到今日推荐
     * @param tops
     * @return
     */
    int addTops(Tops tops);

    /**
     * 移出今日推荐
     * @param goodId
     * @return
     */
    int deleteTops(Integer goodId);
}
