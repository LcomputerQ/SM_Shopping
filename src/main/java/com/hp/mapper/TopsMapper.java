package com.hp.mapper;

import com.hp.pojo.Tops;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface TopsMapper {
    Tops getByGoodId(Integer goodId);

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
