package com.hp.service;

import com.hp.pojo.Users;

public interface UsersService {
    /**
     * 用户登录
     * @param users
     * @return
     */
    Users login(Users users);
}
