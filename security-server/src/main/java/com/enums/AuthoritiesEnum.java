package com.enums;

import lombok.Getter;

/**
 * @author：linma
 * @date: 2018/11/2 12:09
 * @email: linma@homeinns.com
 **/
@Getter
public enum AuthoritiesEnum {

    /**
     * 管理员账户
     */
    ADMIN("ROLE_ADMIN");

    private String role;

    AuthoritiesEnum(String role) {
        this.role = role;
    }
}
