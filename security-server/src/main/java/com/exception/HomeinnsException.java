package com.exception;

import lombok.Getter;

/**
 * @author：linma
 * @date: 2018/10/31 12:01
 * @email: linma@homeinns.com
 **/
@Getter
public class HomeinnsException extends RuntimeException {

    private Integer code;

    public HomeinnsException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
