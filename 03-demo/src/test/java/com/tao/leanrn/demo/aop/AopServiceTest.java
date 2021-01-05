package com.tao.leanrn.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class AopServiceTest {

    @Autowired
    private AopService aopService;

    @Test
    void save() {
        User user = new User();
        user.setId(1L);
        user.setAge(19);
        user.setUsername("booleandev");
        User user1 = aopService.save(user);
        log.info("------------->user1={}", user1);
    }
}