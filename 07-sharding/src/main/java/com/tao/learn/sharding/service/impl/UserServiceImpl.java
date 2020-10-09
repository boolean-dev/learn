package com.tao.learn.sharding.service.impl;

import com.tao.learn.sharding.dao.UserDao;
import com.tao.learn.sharding.entity.User;
import com.tao.learn.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Jiantao Yan
 * @description: User Service 实现层
 * @title: UserServiceImpl
 * @date 2019/12/24 15:03
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {

        return userDao.findAll();
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<User> transaction(User user) {
        userDao.deleteById(user.getId());
        return userDao.findAll();
    }
}
