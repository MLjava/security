package com.enums;

import lombok.Getter;

/**
 * @author：linma
 * @date: 2018/10/31 12:03
 * @email: linma@homeinns.com
 **/
@Getter
public enum CommonEnum {

    /**
     * 用户权限不够
     */
    ROLE_NOT_ALLOWED(403, "当前用户角色权限不够！"),

    /**
     * 统一错误
     */
    NOT_KNOW_EXCEPTION(500, "糟糕了，服务器出现错误了！");

    private Integer code;

    private String message;

    CommonEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
