package com.tao.learn.shardingsphere.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tao.learn.shardingsphere.entity.User;

import java.util.List;

/**
 * @author 谛听
 * @date 2019/11/5 20:21
 **/
public interface UserService extends IService<User> {

    /**
     * 保存用户信息
     * @param entity
     * @return
     */
    @Override
    boolean save(User entity);

    /**
     * 查询全部用户信息
     * @return
     */
    List<User> getUserList();
}