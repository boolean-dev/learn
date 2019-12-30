package com.tao.learn.sharding.service;

import com.tao.learn.sharding.entity.User;

import java.util.List;

/**
 * @author Jiantao Yan
 * @description: User Service接口层
 * @title: UserService
 * @date 2019/12/24 15:03
 */
public interface UserService {

    List<User> findAll();

    User save(User user);

    void update(User user);

    void delete(Long id);
}
