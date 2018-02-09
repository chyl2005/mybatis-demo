package com.github.mybatis.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.mybatis.bean.UserDO;
import com.github.mybatis.mapper.UserMapper;

/**
 * @author:chenyanlong@meituan.com
 * @date:18/2/7
 * @time:16:42
 * @desc:描述该类的作用
 */
@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    public void findByIdTwoTimes() {
        long startTime = System.currentTimeMillis();
        UserDO userDO = userMapper.findById(1);
        long firstTime = System.currentTimeMillis();
        LOGGER.info("第一次请求耗时：{}", firstTime - startTime);
        UserDO userDO1 = userMapper.findById(1);
        LOGGER.info("第二次请求耗时：{}", System.currentTimeMillis() - firstTime);
    }

    public void findByIdTwoTimesNoTransaction() {
        long startTime = System.currentTimeMillis();
        UserDO userDO = userMapper.findById(1);
        long firstTime = System.currentTimeMillis();
        LOGGER.info("第一次请求耗时：{}", firstTime - startTime);
        UserDO userDO1 = userMapper.findById(1);
        LOGGER.info("第二次请求耗时：{}", System.currentTimeMillis() - firstTime);
    }

    @Transactional
    public void updateSelect() {
        //spring无事务查询   userName唯一索引
        userMapper.findById(1);
        userMapper.findById(1);
        UserDO userDO = new UserDO();
        userDO.setId(1);
        userDO.setUserName("admin");
        userDO.setPassword("admin");
        userMapper.insertOrUpdate(userDO);
        userMapper.findById(1);
    }

}
