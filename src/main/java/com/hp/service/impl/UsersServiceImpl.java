package com.hp.service.impl;

import com.hp.mapper.UsersMapper;
import com.hp.pojo.Users;
import com.hp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public Users login(Users users) {
        return usersMapper.login(users);
    }
}
