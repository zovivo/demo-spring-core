package com.demo.spring.utils;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {

    public void logBefore(JoinPoint joinPoint) {
        System.err.println("******");
        System.err.println("class name: " + joinPoint.getTarget().getClass());
        System.err.println("method name :)))) : " + joinPoint.getSignature().getName());
        System.err.println("logBefore() is running!");
        System.err.println("******");
    }

    public void logAfter(JoinPoint joinPoint) {
        System.err.println("******");
        System.err.println("class name: " + joinPoint.getTarget().getClass());
        System.err.println("method name :)))) : " + joinPoint.getSignature().getName());
        System.err.println("logAfter() is running!");
        System.err.println("******");
    }

    public void logAfterReturning(JoinPoint joinPoint) {
        System.err.println("******");
        System.err.println("class name: " + joinPoint.getTarget().getClass());
        System.err.println("method name :)))) : " + joinPoint.getSignature().getName());
        System.err.println("logAfterReturning() is running!");
        System.err.println("******");
    }

    public void logAfterThrowing(JoinPoint joinPoint) {
        System.err.println("******");
        System.err.println("class name: " + joinPoint.getTarget().getClass());
        System.err.println("method name :)))) : " + joinPoint.getSignature().getName());
        System.err.println("logAfterThrowing() is running!");
        System.err.println("******");
    }

}