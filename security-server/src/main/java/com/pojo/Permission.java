package com.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author：linma
 * @date: 2018/11/1 17:45
 * @email: linma@homeinns.com
 **/
@Data
public class Permission {

    private Integer id;

    private String permissionName;

    private Integer roleId;

    private Date updateTime;

    private Integer flag;
}
