package com.hp.mapper;

import com.hp.pojo.Tops;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface TopsMapper {
    Tops getByGoodId(Integer goodId);
}
