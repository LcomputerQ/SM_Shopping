package com.hp.service.impl;

import com.hp.mapper.TypesMapper;
import com.hp.pojo.Types;
import com.hp.service.TypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesServiceImpl implements TypesService {
    @Autowired
    private TypesMapper typesMapper;
    @Override
    public int addTypes(Types types) {
        return typesMapper.addTypes(types);
    }

    @Override
    public List<Types> getAll() {
        return typesMapper.getAll();
    }

    @Override
    public int deleteTypes(Integer id) {
        return typesMapper.deleteTypes(id);
    }

    @Override
    public Types getById(Integer id) {
        return typesMapper.getById(id);
    }

    @Override
    public int updateTypes(Types types) {
        return typesMapper.updateTypes(types);
    }
}
