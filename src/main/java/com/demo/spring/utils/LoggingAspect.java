package com.demo.spring.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* addC*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.err.println("******");
        System.err.println("logBefore() is running!");
        System.err.println("testing Aspect :)))) : " + joinPoint.getSignature().getName());
        System.err.println("******");
    }

}