package com.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author：linma
 * @date: 2018/10/31 12:27
 * @email: linma@homeinns.com
 **/
@Data
public class User {

    private String id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户的真实姓名
     */
    private String name;

    /**
     * 用户头像
     */
    private String icon;

    private Date updateTime;

    /**
     * 删除标识
     * 0：正常
     * 1：已删除
     */
    private Integer flag;

    private Date addTime;

    /**
     * 用户状态
     * 0：正常
     * 1：锁住
     */
    private Integer lock;

}
