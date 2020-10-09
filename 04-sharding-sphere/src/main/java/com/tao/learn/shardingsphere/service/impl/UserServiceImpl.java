package com.tao.learn.shardingsphere.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tao.learn.shardingsphere.entity.User;
import com.tao.learn.shardingsphere.mapper.UserMapper;
import com.tao.learn.shardingsphere.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 谛听
 * @date 2019/11/5 20:22
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public boolean save(User entity) {
        return super.save(entity);
    }

    @Override
    public List<User> getUserList() {
        return baseMapper.selectList(Wrappers.<User>lambdaQuery());
    }
}