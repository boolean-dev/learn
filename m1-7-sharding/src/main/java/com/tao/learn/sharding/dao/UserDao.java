package com.tao.learn.sharding.dao;

import com.tao.learn.sharding.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author Jiantao Yan
 * @description: 用户dao层
 * @title: UserServiceImpl
 * @date 2019/12/24 15:03
 */
@Component
public interface UserDao extends JpaRepository<User, Long> {
}
