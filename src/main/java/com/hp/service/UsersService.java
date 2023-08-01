package com.hp.service;

import com.hp.pojo.Users;

import java.util.Map;

public interface UsersService {
    /**
     * 用户登录
     * @param users
     * @return
     */
    Users login(Users users);
    /**
     * 查看用户消息
     * @param id
     * @return
     */
    Users getById(Integer id);

    /**
     * 分页查询所有用户消息
     * @param page
     * @return
     */
    Map<String,Object> getAll(Integer page);
    /**
     * 修改用户信息
     *
     * @param users
     * @return
     */
    int update(Users users);
    /**
     * 添加用户
     * @param users
     * @return
     */
    int save(Users users);
    /**
     * 删除用户
     * @param id
     * @return
     */
    int delete(Integer id);
}
