package com.constant;

/**
 * @author：linma
 * @date: 2018/10/31 12:06
 * @email: linma@homeinns.com
 **/
public interface CommonConstant {

    /**
     * 请求成功
     */
    Integer REQUEST_OK = 200;

    /**
     * 验证码不可以为空
     */
    Integer IDENTITY_CODE_MUST_NOT_NULL = 4;

    /**
     * 验证码不匹配
     */
    Integer IDENTITY_CODE_CAN_NOT_MATE = 4;

    /**
     * 服务器错误
     */
    Integer RESPONSE_ERROR = 500;

    /**
     * 未认证的请求
     */
    Integer SC_UNAUTHORIZED = 401;

    interface Message {

        String REQUEST_OK_MESSAGE = "请求成功!";

        String RESPONSE_ERROR_MESSAGE = "服务器错误!";

        String IDENTITY_CODE_MUST_NOT_NULL_MESSAGE = "验证码不可以位空！";

        String IDENTITY_CODE_CAN_NOT_MATE_MESSAGE = "验证码不匹配！";

        String SC_UNAUTHORIZED_MESSAGE = "没有登录的请求！";
    }
}
