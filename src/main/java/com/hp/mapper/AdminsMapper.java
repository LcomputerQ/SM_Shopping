package com.hp.mapper;

import com.hp.pojo.Admins;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminsMapper {
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
    List<Admins> selectAll();

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
