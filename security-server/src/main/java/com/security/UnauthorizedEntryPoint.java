package com.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author：linma
 * @date: 2019/1/29 14:40
 * @email: linma@homeinns.com
 * 定义ajax区段
 **/
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

    /**
     * 判断ajax请求方式
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
            if (isAjaxRequest(request)) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
            } else {
                response.sendRedirect("/homeinns/login");
            }
    }

    /**
     * 判断是否为ajax请求
     */
    private static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(ajaxFlag);
    }
}
