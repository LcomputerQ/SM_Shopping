package com.hp.mapper;

import com.hp.pojo.Types;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypesMapper {
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
