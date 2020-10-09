package com.tao.learn.sharding.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Jiantao Yan
 * @description: TODO
 * @title: TestAopDao
 * @date 2020/1/10 14:33
 */
@Component
public class TestAopDao {

    public void fun1() {
        System.out.println("fun1()..........");
    }

    public void fun2() {
        System.out.println("fun1()..........");
    }
}
