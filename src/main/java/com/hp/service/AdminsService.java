package com.hp.service;

import com.hp.pojo.Admins;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminsService {
    /**
     * 管理员登录
     * @param admins
     * @return
     */
    Admins login(Admins admins);
    /**
     * 查询所有管理员账号
     * @return
     */
    Map<String,Object> selectAll(Integer page);
    /**
     * 修改管理员
     * @param admins
     * @return
     */
    int update(Admins admins);
    /**
     * 删除普通管理员
     * @param id
     * @return
     */
    int delete(Integer id);
    /**
     * 添加账号
     * @param admins
     * @return
     */
    int inset(Admins admins);

}
