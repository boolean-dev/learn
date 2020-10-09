package com.tao.learn.sharding.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestAopDaoTest {

    @Autowired
    private TestAopDao testAopDao;

    @Test
    void fun1() {
        testAopDao.fun1();
    }

    @Test
    void fun2() {
        testAopDao.fun2();
    }
}