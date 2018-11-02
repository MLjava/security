package com.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author：linma
 * @date: 2018/11/1 17:44
 * @email: linma@homeinns.com
 **/
@Data
public class Role {

    private Integer id;

    private String roleName;

    private String userId;

    private Date updateTime;

    private Integer flag;
}
