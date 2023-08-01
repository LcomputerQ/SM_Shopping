package com.hp.mapper;

import com.hp.pojo.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
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
     * 查看所有用户消息
     * @return
     */
    List<Users> getAll();

    /**
     * 修改用户信息
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
