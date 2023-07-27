package com.hp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hp.mapper.AdminsMapper;
import com.hp.pojo.Admins;
import com.hp.service.AdminsService;
import com.hp.utlis.Safe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminsServiceImpl implements AdminsService {
    @Autowired
    private AdminsMapper adminsMapper;
    @Override
    public Admins login(Admins admins) {
        return adminsMapper.login(admins);
    }

    @Override
    public Map<String,Object> selectAll(Integer page) {
        PageHelper.startPage(page,5);
        List<Admins> admins = adminsMapper.selectAll();
        Page<Admins> pages =(Page<Admins>)admins;
        Map<String, Object> map = new HashMap<>();
        map.put("numPage",(pages.getTotal()/5)+1);
        if(pages.getTotal()%5==0)
            map.put("numPage",(pages.getTotal()/5));
        map.put("total",pages.getTotal());
        map.put("page",page);
        map.put("list",pages.getResult());
        return map;
    }

    @Override
    public int update(Admins admins) {
        admins.setPassword(Safe.md5(admins.getPassword()));
        return adminsMapper.update(admins);
    }

    @Override
    public int delete(Integer id) {
        return adminsMapper.delete(id);
    }

    @Override
    public int inset(Admins admins) {
        admins.setPassword(Safe.md5(admins.getPassword()));
        return adminsMapper.inset(admins);
    }
}
