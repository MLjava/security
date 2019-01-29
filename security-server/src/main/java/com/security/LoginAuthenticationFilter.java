package com.security;

import com.enums.CaptchaEnum;
import com.exception.CaptchaException;
import com.google.code.kaptcha.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author：linma
 * @date: 2019/1/28 13:59
 * @email: linma@homeinns.com
 * 添加验证码信息拦截器
 **/
@Slf4j
public class LoginAuthenticationFilter extends OncePerRequestFilter {

    /**
     * 验证码逻辑判断
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // 判断url地址，是否需要去拦截
        if (StringUtils.equals("/homeinns/login", request.getRequestURI())
                && StringUtils.equalsIgnoreCase(request.getMethod(), "post")) {
            // 从表单获取用户输入的验证码
            String verification = request.getParameter("verification");
            // 从session获取验证码
            String captcha = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            // 验证码输入为空
            if (StringUtils.isBlank(verification)) {
                throw new CaptchaException(CaptchaEnum.IDENTITY_CODE_MUST_NOT_NULL);
            }
            // 验证码不匹配
            if (!captcha.equals(verification)) {
                throw new CaptchaException(CaptchaEnum.IDENTITY_CODE_CAN_NOT_MATE);
            }
        }
        filterChain.doFilter(request, response);
    }
}
