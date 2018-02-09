package com.github.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.github.mybatis.bean.UserDO;

/**
 * @author:chenyanlong@meituan.com
 * @date:18/2/7
 * @time:16:42
 * @desc:描述该类的作用
 */
@Repository
public interface UserMapper {

    void insertOrUpdate(UserDO userDO);

    UserDO findById(@Param("id") Integer id);


   Integer deleteById(@Param("id") Integer id);
}
