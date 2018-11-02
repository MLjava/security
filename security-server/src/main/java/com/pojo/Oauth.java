package com.pojo;

import lombok.Data;

/**
 * @author：linma
 * @date: 2018/11/2 9:22
 * @email: linma@homeinns.com
 **/
@Data
public class Oauth {

    private Integer id;

    private String clientId;

    private String clientSecret;

    private String scope;

    private String authorizedGrantTypes;
}