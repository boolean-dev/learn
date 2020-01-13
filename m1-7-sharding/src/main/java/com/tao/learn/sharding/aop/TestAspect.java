package com.tao.learn.sharding.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

/**
 * @author Jiantao Yan
 * @description: TODO
 * @title: TestAspect
 * @date 2020/1/10 14:32
 */

@Aspect
@Component
@Slf4j
public class TestAspect {

    @Pointcut("execution(* com.tao.learn.sharding.dao.TestAopDao.*(..))")
    public void pointcut() {
    }
    @Around("pointcut()")
    public Object doBasicProfiling(@NotNull ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch

        System.out.println("before beginTransaction");


        Object retVal = pjp.proceed();
        // stop stopwatch

        System.out.println("after commit");

        return retVal;
    }

}
