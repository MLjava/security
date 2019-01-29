package com.config;

import com.enums.CommonEnum;
import com.enums.ResultEnum;
import com.exception.CaptchaException;
import com.exception.CommonException;
import com.exception.HomeinnsException;
import com.utils.ResultUtils;
import com.utils.ResultVO;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：linma
 * @date: 2018/10/31 12:09
 * @email: linma@homeinns.com
 **/
@RestController
@ControllerAdvice
public class GlobalExceptionConfig {

    /**
     * 统一捕获异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ResultVO runtimeExceptionHandle(Exception e) {
        if (e instanceof RuntimeException) {
            // 业务异常
            if (e instanceof HomeinnsException) {
                HomeinnsException homeinnsException = (HomeinnsException) e;
                return ResultUtils.failure(homeinnsException);
            }
            // security权限异常
            if (e instanceof AccessDeniedException) {
                CommonException commonException = new CommonException(CommonEnum.ROLE_NOT_ALLOWED);
                return ResultUtils.failure(commonException);
            }
        }
        return ResultUtils.failure(new CommonException(CommonEnum.NOT_KNOW_EXCEPTION));
    }
}
