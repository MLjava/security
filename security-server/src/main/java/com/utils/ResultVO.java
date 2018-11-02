package com.utils;

import lombok.Data;

/**
 * @author：linma
 * @date: 2018/10/31 12:05
 * @email: linma@homeinns.com
 **/
@Data
public class ResultVO<T> {

    private Integer code;

    private String message;

    private T data;
}
