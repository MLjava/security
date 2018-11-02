package com.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author：linma
 * @date: 2018/10/31 12:18
 * @email: linma@homeinns.com
 **/
@Aspect
@Component
@Slf4j
public class ServiceLogAop {

    @Pointcut("execution(public * com.services.impl.*.*(..))")
    private void services() {

    }

    @Before(value = "services()")
    public void methodBefore(JoinPoint joinPoint) {

    }

    @After(value = "services()")
    public void methodAfter(JoinPoint joinPoint) {

    }

}
