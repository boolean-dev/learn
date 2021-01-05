package com.tao.leanrn.demo.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 *
 * @author Jiantao Yan
 * @title: LogAspect
 * @date 2021/1/5 20:33
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    /**
     * 以注解为切入点
     */
    @Pointcut("@annotation(com.tao.leanrn.demo.aop.Log)")
    public void pointcut() {
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     */
    @SneakyThrows
    @Around("pointcut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        // 获取入参
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            // 入参是否为 user
            if (arg instanceof User) {
                log.info("------->入参为user={}", (User)arg);
            }
            log.info("----->入参 arg={}", arg);
        }

        // 获取出参
        Object result = proceedingJoinPoint.proceed();
        // 出参是否为 user
        if (result instanceof User) {
            log.info("------->入参为user,result={}", (User)result);
        }
        log.info("----->出参.result={}", result);

    }
}
