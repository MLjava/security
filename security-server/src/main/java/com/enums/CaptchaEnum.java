package com.enums;

import com.constant.CommonConstant;
import lombok.Getter;

/**
 * @author：linma
 * @date: 2019/1/28 14:09
 * @email: linma@homeinns.com
 * <p>
 * 验证码统一异常
 **/
@Getter
public enum CaptchaEnum {

    /**
     * 验证码位空
     */
    IDENTITY_CODE_MUST_NOT_NULL(CommonConstant.IDENTITY_CODE_MUST_NOT_NULL,
            CommonConstant.Message.IDENTITY_CODE_MUST_NOT_NULL_MESSAGE),

    /**
     * 验证码不匹配
     */
    IDENTITY_CODE_CAN_NOT_MATE(CommonConstant.IDENTITY_CODE_MUST_NOT_NULL,
            CommonConstant.Message.IDENTITY_CODE_MUST_NOT_NULL_MESSAGE);

    private Integer code;

    private String message;

    CaptchaEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
