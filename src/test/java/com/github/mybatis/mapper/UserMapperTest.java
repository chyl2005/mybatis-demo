package com.github.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.github.mybatis.bean.UserDO;
import com.github.mybatis.service.UserService;

/**
 * @author:chenyanlong@meituan.com
 * @date:18/2/7
 * @time:16:58
 * @desc:描述该类的作用
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationcontext.xml")
public class UserMapperTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    public void testHasTransaction() {
        //spring有事务查询
        userService.findByIdTwoTimes();
    }

    @Test
    public void testNoTransaction() {
        //spring无事务查询
        userService.findByIdTwoTimesNoTransaction();
    }

    @Test
    public void testUpdateSelect() {
        //spring无事务查询   userName唯一索引
        userService.updateSelect();
    }

    @Test
    public void testCacheSession() {
        //openSession 测试
        LOGGER.info("本地缓存范围: " + sqlSessionFactory.getConfiguration().getLocalCacheScope());
        LOGGER.info("二级缓存是否被启用: " + sqlSessionFactory.getConfiguration().isCacheEnabled());
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.findById(1);
        userMapper.findById(1);
        sqlSession.close();
    }

}
