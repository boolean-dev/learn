package com.tao.leanrn.mybatis.dao;

import com.tao.leanrn.mybatis.entity.User;
import com.tao.leanrn.mybatis.proxy.MethodProxyFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class UserMapperTest {


    @Test
    public void addUser() {
        UserMapper userMapper = MethodProxyFactory.getBean(UserMapper.class);
        userMapper.addUser("boolean-","123456");
        log.info("---------->");
    }

    @Test
    public void findUsers() {
        UserMapper userMapper = MethodProxyFactory.getBean(UserMapper.class);
        List<User> list = userMapper.findUsers();
        log.info("---------->list={}", list);
    }

    @Test
    public void getUser() {
        UserMapper userMapper = MethodProxyFactory.getBean(UserMapper.class);
        User user = userMapper.getUser(2);
        log.info("---------->user={}", user);
    }

    @Test
    public void updateUser() {
        UserMapper userMapper = MethodProxyFactory.getBean(UserMapper.class);
        Integer result = userMapper.updateUser("鄢剑涛update", "yjt123", 1);
        log.info("count={}", result);
    }

    @Test
    public void deleteUser() {
        UserMapper userMapper = MethodProxyFactory.getBean(UserMapper.class);
        Integer count = userMapper.deleteUser(1);
        log.info("count={}", count);
    }
}