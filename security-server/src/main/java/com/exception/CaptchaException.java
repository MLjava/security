package com.exception;

import com.enums.CaptchaEnum;

/**
 * @author：linma
 * @date: 2019/1/28 14:08
 * @email: linma@homeinns.com
 **/
public class CaptchaException extends HomeinnsException {

    public CaptchaException(CaptchaEnum captchaEnum) {
        super(captchaEnum.getCode(), captchaEnum.getMessage());
    }
}
