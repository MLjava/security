package com.enums;

import lombok.Getter;

/**
 * @author：linma
 * @date: 2018/10/31 12:12
 * @email: linma@homeinns.com
 **/
@Getter
public enum ResultEnum {

   ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
