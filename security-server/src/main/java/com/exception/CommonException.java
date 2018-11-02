package com.exception;

import com.enums.CommonEnum;
import com.enums.ResultEnum;

/**
 * @author：linma
 * @date: 2018/10/31 12:10
 * @email: linma@homeinns.com
 **/
public class CommonException extends HomeinnsException {

    public CommonException(Integer code, String message) {
        super(code, message);
    }

    public CommonException(CommonEnum commonEnum) {
        this(commonEnum.getCode(), commonEnum.getMessage());
    }

}
