package com.tao.leanrn.mybatis.dao;

import com.tao.leanrn.mybatis.proxy.MethodProxyFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.*;

@Slf4j
public class UserMapperTest {


    @Test
    public void addUser() {
        UserMapper userMapper = MethodProxyFactory.getBean(UserMapper.class);
        userMapper.addUser("boolean","123456");
        log.info("---------->");
    }

    @Test
    public void findUsers() {
    }

    @Test
    public void getUser() {
    }

    @Test
    public void updateUser() {
        UserMapper userMapper = MethodProxyFactory.getBean(UserMapper.class);
        Integer result = userMapper.updateUser("鄢剑涛update", "yjt123", 1);
        log.info("count={}", result);
    }

    @Test
    public void deleteUser() {
    }
}