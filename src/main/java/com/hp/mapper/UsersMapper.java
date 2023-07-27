package com.hp.mapper;

import com.hp.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {
    /**
     * 用户登录
     * @param users
     * @return
     */
    Users login(Users users);
}
