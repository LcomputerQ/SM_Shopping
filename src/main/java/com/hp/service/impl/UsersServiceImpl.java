package com.hp.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hp.mapper.UsersMapper;
import com.hp.pojo.Users;
import com.hp.service.UsersService;
import com.hp.utlis.Safe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public Users login(Users users) {
        return usersMapper.login(users);
    }

    /**
     * 查看用户消息
     *
     * @param id
     * @return
     */
    @Override
    public Users getById(Integer id) {
        return usersMapper.getById(id);
    }

    /**
     * 分页查询所有用户消息
     *
     * @param page
     * @return
     */
    @Override
    public Map<String, Object> getAll(Integer page) {
        PageHelper.startPage(page,5);
        List<Users> userList = usersMapper.getAll();
        Page<Users> pages = (Page<Users>)userList;
        Map<String,Object> map = new HashMap();
        map.put("page",page);
        map.put("numPage",pages.getTotal()%5==0?pages.getTotal()/5:pages.getTotal()/5+1);
        map.put("list",pages.getResult());
        return map;
    }

    /**
     * 修改用户信息
     *
     * @param users
     * @return
     */
    @Override
    public int update(Users users) {
        return usersMapper.update(users);
    }

    /**
     * 添加用户
     *
     * @param users
     * @return
     */
    @Override
    public int save(Users users) {
        users.setPassword(Safe.md5(users.getPassword()));
        return usersMapper.save(users);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public int delete(Integer id) {
        return usersMapper.delete(id);
    }

}
