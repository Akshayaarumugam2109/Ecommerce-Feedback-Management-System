package com.examly.springapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    
    @Before("execution(* com.examly.springapp.controller.*.*(..))")
    public void logBeforeControllerMethods(JoinPoint joinPoint) {
        logger.info("Executing controller method: {} with arguments: {}", 
                   joinPoint.getSignature().getName(), joinPoint.getArgs());
    }
    
    @After("execution(* com.examly.springapp.controller.*.*(..))")
    public void logAfterControllerMethods(JoinPoint joinPoint) {
        logger.info("Completed controller method: {}", joinPoint.getSignature().getName());
    }
    
    @Around("execution(* com.examly.springapp.service.*.*(..))")
    public Object logAroundServiceMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        logger.info("Starting service method: {} with arguments: {}", 
                   proceedingJoinPoint.getSignature().getName(), proceedingJoinPoint.getArgs());
        
        try {
            Object result = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis();
            
            logger.info("Service method: {} completed successfully in {} ms", 
                       proceedingJoinPoint.getSignature().getName(), (endTime - startTime));
            
            return result;
        } catch (Exception e) {
            long endTime = System.currentTimeMillis();
            
            logger.error("Service method: {} failed after {} ms with exception: {}", 
                        proceedingJoinPoint.getSignature().getName(), (endTime - startTime), e.getMessage());
            
            throw e;
        }
    }
    
    @Before("execution(* com.examly.springapp.repository.*.*(..))")
    public void logBeforeRepositoryMethods(JoinPoint joinPoint) {
        logger.debug("Executing repository method: {}", joinPoint.getSignature().getName());
    }
}