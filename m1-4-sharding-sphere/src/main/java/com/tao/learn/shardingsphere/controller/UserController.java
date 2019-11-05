package com.tao.learn.shardingsphere.controller;

import com.tao.learn.shardingsphere.entity.User;
import com.tao.learn.shardingsphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author 谛听
 * @date 2019/11/5 20:25
 **/

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/select")
    public List<User> select() {
        return userService.getUserList();
    }

    @GetMapping("/insert")
    public Boolean insert(User user) {
        user.setId(null);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return userService.save(user);
    }
}