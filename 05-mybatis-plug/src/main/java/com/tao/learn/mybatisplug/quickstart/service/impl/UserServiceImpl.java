package com.tao.learn.mybatisplug.quickstart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tao.learn.mybatisplug.quickstart.entity.User;
import com.tao.learn.mybatisplug.quickstart.mapper.UserMapper;
import com.tao.learn.mybatisplug.quickstart.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户service
 *
 * @author 谛听
 * @date 2019/11/7 11:21
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}