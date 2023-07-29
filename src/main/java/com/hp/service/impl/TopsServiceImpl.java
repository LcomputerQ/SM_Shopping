package com.hp.service.impl;

import com.hp.mapper.TopsMapper;
import com.hp.pojo.Tops;
import com.hp.service.TopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopsServiceImpl implements TopsService {
    @Autowired
    private TopsMapper topsMapper;
    @Override
    public int addTops(Tops tops) {
        return topsMapper.addTops(tops);
    }

    @Override
    public int deleteTops(Integer goodId) {
        return topsMapper.deleteTops(goodId);
    }
}
