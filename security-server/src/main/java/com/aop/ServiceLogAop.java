package com.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author：linma
 * @date: 2018/10/31 12:18
 * @email: linma@homeinns.com
 **/
@Aspect
@Component
@Slf4j
public class ServiceLogAop {

    /**
     * 方法调用开始时间
     */
    private Long startTime;

    /**
     * 方法调用结束时间
     */
    private Long endTime;

    /**
     * 申明一个切入点
     */
    @Pointcut("execution(public * com.services.impl..*ServiceImpl.*(..))")
    private void servicesAspect() {
    }

    /**
     * 调用方法前执行
     *
     * @param joinPoint
     */
    @Before(value = "servicesAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        log.info("================ 业务开始调用 ======================");
        startTime = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // ----------- 打印基本信息 -------------- //
        log.info("IP: " + request.getRemoteAddr());
        log.info("USER: " + request.getRemoteUser());
        log.info("URL: " + request.getRequestURL().toString());
        log.info("HTTP_METHOD: " + request.getMethod());
        log.info("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName());
        log.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            log.info("PARAMETER: " + paraName + " = " + request.getParameter(paraName));
        }
    }

    /**
     * 调用方法后执行
     *
     * @param joinPoint
     */
    @After(value = "servicesAspect()")
    public void methodAfter(JoinPoint joinPoint) {
        log.info("================ 业务结束调用 ======================");
        endTime = System.currentTimeMillis();
        log.info("业务调用时间为：" + spendTime(startTime, endTime));
    }

    private long spendTime(long startTime, long endTime) {
        return endTime - startTime;
    }
}
