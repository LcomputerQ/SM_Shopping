package com.hp.service;

import com.hp.pojo.Types;

import java.util.List;

public interface TypesService {
    /**
     * 添加类目
     * @param types
     * @return
     */
    int addTypes(Types types);
    /**
     * 获取所有类目
     * @return
     */
    List<Types> getAll();
    /**
     * 删除类目
     * @param id
     * @return
     */
    int deleteTypes(Integer id);

    /**
     * 根据id查找类目
     * @param id
     * @return
     */
    Types getById(Integer id);
    /**
     * 更新类目
     * @param types
     * @return
     */
    int updateTypes(Types types);
}
