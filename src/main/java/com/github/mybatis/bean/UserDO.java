package com.github.mybatis.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author:chenyanlong@meituan.com
 * @date:18/2/7
 * @time:16:44
 * @desc:描述该类的作用
 */
@Data
public class UserDO {

    private Integer id;
    private String userName;
    private String password;
    private Date gmtModified;
    private Date gmtCreated;
    private Integer isDel;
}
