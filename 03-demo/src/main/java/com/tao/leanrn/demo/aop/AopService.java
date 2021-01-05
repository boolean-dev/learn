package com.tao.leanrn.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * AOP 切入点测试
 *
 * @author Jiantao Yan
 * @title: AopService
 * @date 2021/1/5 20:29
 */
@Slf4j
@Service
public class AopService {

    @Log
    public User save(User user) {
        log.info("------>save user={}", user);
        return user;
    }
}
